package com.fissionlabs.datageneration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import au.com.bytecode.opencsv.CSVReader;

import com.fissionlabs.model.AadhaarDetails;

public class HttpDownloader1 {
	static ArrayList<AadhaarDetails> adharDetailsList = new ArrayList<AadhaarDetails>();

	public static void main(String[] args) throws Exception {
		String fileURL = "https://data.uidai.gov.in/uiddatacatalog/rest/UIDAI-ENR-DETAIL";
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		String saveDir = "D:/ZipFiles/" + format.format(new Date()) + ".zip";

		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(X509Certificate[] certs,
					String authType) {
			}

			public void checkServerTrusted(X509Certificate[] certs,
					String authType) {
			}

		} };

		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, new java.security.SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

		// Create all-trusting host name verifier
		@SuppressWarnings("unused")
		HostnameVerifier allHostsValid = new HostnameVerifier() {
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		};

		try {
			HttpDownloadUtility.downloadFile(fileURL, saveDir);
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		try {
			File folder = new File("D:/POCFiles");
			if (!folder.exists()) {
				folder.mkdir();
			}
			ZipInputStream zis = new ZipInputStream(
					new FileInputStream(saveDir));
			// get the zipped file list entry
			ZipEntry ze = zis.getNextEntry();
			while (ze != null) {
				String fileName = ze.getName();
				File newFile = new File("D:/POCFiles" + File.separator
						+ fileName);
				new File(newFile.getParent()).mkdirs();
				FileOutputStream fos = new FileOutputStream(newFile);
				byte[] buffer = new byte[1024];
				int len;
				while ((len = zis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				fos.close();
				ze = zis.getNextEntry();
				CSVReader csvReader = new CSVReader(new FileReader(
						"D:/POCFiles/" + "UIDAI-ENR-DETAIL-20160602.csv"));
				List content = csvReader.readAll();
				int size = content.size();
				String[] row = null;
				Long currentTIme = System.currentTimeMillis();
				for (int i = 1; i < size; i++) {
					try {
						Object object = content.get(i);
						row = (String[]) object;
						AadhaarDetails aadhaar = new AadhaarDetails();
						aadhaar.setRegistrar(row[0]);
						aadhaar.setEnrolmentAgency(row[1]);
						aadhaar.setState(row[2]);
						aadhaar.setDistrict(row[3]);
						aadhaar.setSubDistrict(row[4]);
						aadhaar.setPinCode(Integer.parseInt(row[5]));
						aadhaar.setGender(row[6]);
						aadhaar.setAge(Integer.parseInt(row[7]));
						aadhaar.setAadhaarGenerated(Integer.parseInt(row[8]));
						aadhaar.setEnrolment(Integer.parseInt(row[9]));
						aadhaar.setDate(new Date());
						adharDetailsList.add(aadhaar);

						if (i % 100 == 0 && i != 0) {
							createThread(adharDetailsList, currentTIme);

							adharDetailsList = new ArrayList<AadhaarDetails>();
						}

					} catch (Exception e) {
						System.out.println("message is: " + e.getMessage());
					}
				}
			}
			zis.closeEntry();
			zis.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static void createThread(
			ArrayList<AadhaarDetails> adharDetailsList2, Long currentTime) {
		// TODO Auto-generated method stub
		AddAadharDetailsTask task = new AddAadharDetailsTask(adharDetailsList2);
		task.currentTime = currentTime;
		executor.execute(task);

	}

	static ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors
			.newFixedThreadPool(10);

}