package com.pharmachain.pharma_supply_chain.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.awt.image.BufferedImage;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Base64;
import java.util.Map;

@Service
public class QRCodeService {

    /**
     * Generate QR code as base64 string
     * @param data The data to encode
     * @return Base64 encoded QR code image
     */
    public String generateQRCode(String data) {
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            var bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, 200, 200);
            BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);

            // Convert to base64
            java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
            javax.imageio.ImageIO.write(image, "PNG", baos);
            String base64 = Base64.getEncoder().encodeToString(baos.toByteArray());

            System.out.println("QR Code generated successfully");
            return "data:image/png;base64," + base64;
        } catch (WriterException | java.io.IOException e) {
            System.err.println("Error generating QR Code: " + e.getMessage());
            throw new RuntimeException("Failed to generate QR Code", e);
        }
    }

    /**
     * Parse QR code data (extract parameters from URL)
     * @param qrCodeData The QR code data to parse
     * @return Map of query parameters
     */
    public Map<String, String> parseQRCodeData(String qrCodeData) {
        try {
            URI uri = new URI(qrCodeData);
            var queryParams = UriComponentsBuilder.fromUri(uri)
                    .build()
                    .getQueryParams();

            System.out.println("Parsed QR Code data: " + queryParams);
            return queryParams.toSingleValueMap();
        } catch (URISyntaxException e) {
            System.err.println("Error parsing QR Code data: " + e.getMessage());
            throw new RuntimeException("Failed to parse QR Code data", e);
        }
    }
}