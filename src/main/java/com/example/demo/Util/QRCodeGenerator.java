package com.example.demo.Util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRCodeGenerator {
    private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/static/qr/";
    public static void generateQRCodeImage(String text)
            throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode("http://localhost:8005/workingspace/datameja/scan/"+text, BarcodeFormat.QR_CODE, 350, 350);

        Path path = FileSystems.getDefault().getPath(QR_CODE_IMAGE_PATH+text+".PNG");
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }
}
