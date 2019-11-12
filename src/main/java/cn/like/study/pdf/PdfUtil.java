package cn.like.study.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDInlineImage;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: MyCode
 * https://zhuanlan.zhihu.com/p/52863069
 * https://github.com/dongdongdeng/pdfboxDemo/blob/master/src/main/java/utils/PDFBoxDemo.java
 * @description:
 * @author: 21936944@qq.com(ilike)
 * @create: 2019-09-07 23:15
 **/
public class PdfUtil {

    private static PDFont FONT = PDType1Font.HELVETICA;
    private static float FONT_SIZE = 10;
    private static final float LEADING = -1.5f * FONT_SIZE;

    public static void main(String[] args) throws IOException {
        //File myFile = new File("/data/tax-api/user_agreement.pdf");
        //String imgFileName = "/Users/ilike/Pictures/teacher.png";
        //System.out.println(readePdf(myFile));
        // addImage(myFile, imgFileName);
        //pdfPage2Img(myFile);
        writePdf();
    }

    private static void writePdf() {
        try {
            InputStream in = PdfUtil.class.getClassLoader().getResourceAsStream("user_agreement_v3.pdf");
            PDDocument document = PDDocument.load(in);

            PDPage page = document.getPage(0);
            //AppendMode：APPEND在原内容后添加；PREPEND在原内容前添加，写入的内容会被覆盖
            PDPageContentStream contentStream = new PDPageContentStream(document, page,
                    PDPageContentStream.AppendMode.APPEND, false);

            InputStream inFont = PdfUtil.class.getClassLoader().getResourceAsStream("simfang.ttf");
            PDType0Font font = PDType0Font.load(document, inFont);
            contentStream.setFont(font, 12);

//            showTextByLeft(contentStream, "从之科技", "", 135,725);
            showTextByLeft(contentStream, "李珂111111111", "", 135, 662);
//            showTextByLeft(contentStream, "男", "", 340,685);
//            showTextByLeft(contentStream, "41022419870616263X", "", 155,653);
//            showTextByLeft(contentStream, "15738888063", "", 360,653);
//            showTextByLeft(contentStream, "1234567890123", "", 155,621);
            contentStream.close();

            PDPage lastPage = document.getPage(document.getNumberOfPages() - 1);
            PDPageContentStream contentStream1 = new PDPageContentStream(document, lastPage,
                    PDPageContentStream.AppendMode.APPEND, false);
            contentStream1.setFont(font, 12);
            showTextByLeft(contentStream1, "2019", "", 170, 520);
            showTextByLeft(contentStream1, "9", "", 220, 520);
            showTextByLeft(contentStream1, "16", "", 255, 520);
            showTextByLeft(contentStream1, "2019", "", 370, 520);
            showTextByLeft(contentStream1, "9", "", 420, 520);
            showTextByLeft(contentStream1, "16", "", 455, 520);

            PDImageXObject pdImage = PDImageXObject.createFromFile("/Users/ilike/Pictures/teacher.png", document);
            contentStream1.drawImage(pdImage, 380, 550, 100, 100);

            contentStream1.close();
            document.save(new File("/data/new_VAT_INVOICE.pdf"));
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addParagraph(PDPageContentStream contentStream, float width, float sx,
                                     float sy, String text, boolean justify) throws IOException {
        List<String> lines = new ArrayList<>();
        parseLinesRecursive(text, width, lines);

        contentStream.setFont(FONT, FONT_SIZE);
        contentStream.newLineAtOffset(sx, sy);
        for (String line : lines) {
            float charSpacing = 0;
            if (justify) {
                if (line.length() > 1) {
                    float size = FONT_SIZE * FONT.getStringWidth(line) / 1000;
                    float free = width - size;
                    if (free > 0 && !lines.get(lines.size() - 1).equals(line)) {
                        charSpacing = free / (line.length() - 1);
                    }
                }
            }
            contentStream.setCharacterSpacing(charSpacing);
            contentStream.showText(line);
            contentStream.newLineAtOffset(0, LEADING);
        }
    }

    private static List<String> parseLinesRecursive(String text, float width, List<String> lines) throws IOException {
        String tmpText = text;
        for (int i = 0; i < text.length(); i++) {
            tmpText = text.substring(0, text.length() - i);

            float realWidth = FONT_SIZE * FONT.getStringWidth(tmpText) / 1000;

            if (realWidth > width) {
                continue;
            } else {
                lines.add(tmpText);

                if (0 != i) {
                    parseLinesRecursive(text.substring(text.length() - i), width, lines);
                }

                break;
            }
        }

        return lines;
    }

    public static void showTextByLeft(PDPageContentStream overContent, String txt, String def, float x, float y)
            throws Exception {
        overContent.beginText();
        if (null == txt) {
            txt = def;
        }
        //Setting the position for the line
        overContent.newLineAtOffset(x, y);

        //overContent.setTextRise(100f);

        //PDInlineImage txtImage = new PDInlineImage();

        //Adding text in the form of string
        overContent.showText(txt);
        //overContent.drawString(txt);

        //Ending the content stream
        overContent.endText();
    }


    public static void pdfPage2Img(File file) throws IOException {
        PDDocument pdDocument = PDDocument.load(file);
        PDFRenderer renderer = new PDFRenderer(pdDocument);
        System.out.println("总页数：" + pdDocument.getNumberOfPages());
        String imgFileName = "/Users/ilike/Pictures/teacher.png";
        for (int i = 0; i < pdDocument.getNumberOfPages(); i++) {
            BufferedImage img_temp = renderer.renderImage(i);
            String imgName = "agreement_img_" + i + ".jpg";
            ImageIO.write(img_temp, "jpg", new File("/data/tax-api/" + imgName));
        }
        pdDocument.close();
    }

    private static BufferedImage merge(BufferedImage image1, BufferedImage image2) {
        BufferedImage combined = new BufferedImage(
                image1.getWidth(),
                image1.getHeight() + image2.getHeight(),
                BufferedImage.TYPE_INT_RGB);

        Graphics g = combined.getGraphics();
        g.drawImage(image1, 0, 0, null);
        g.drawImage(image2, 0, image1.getHeight(), null);
        g.dispose();
        return combined;
    }


    public static void addImage(File file, String img) throws IOException {
        try (PDDocument doc = PDDocument.load(file)) {

            PDPageTree pages = doc.getPages();
            System.out.println(pages.getCount());

            PDImageXObject pdImage = PDImageXObject.createFromFile(img, doc);

            int iw = pdImage.getWidth();
            int ih = pdImage.getHeight();

            float offset = 20f;

            try (PDPageContentStream cont = new PDPageContentStream(doc, pages.get(pages.getCount() - 1),
                    PDPageContentStream.AppendMode
                            .APPEND, true, true)) {

                cont.drawImage(pdImage, offset, offset, iw, ih);
                cont.close();
            }
            doc.save("/data/tax-api/mydoc.pdf");
        }
    }


    public static String readePdf(File file) throws IOException {
        if (file == null || !file.exists()) {
            return "";
        }
        try (PDDocument doc = PDDocument.load(file)) {
            PDFTextStripper stripper = new PDFTextStripper();
            return stripper.getText(doc);
        }
    }


    /***
     * 创建1到多个空白页面
     * @param outputFile
     * @throws IOException
     */
    public static void createBlank(String outputFile) throws IOException {
        //首先创建pdf文档类
        PDDocument document = null;
        try {
            document = new PDDocument();
            //实例化pdf页对象
            PDPage blankPage = new PDPage();
            PDPage blankPage1 = new PDPage();
            PDPage blankPage2 = new PDPage();
            //插入文档类
            document.addPage(blankPage);
            document.addPage(blankPage1);
            document.addPage(blankPage2);
            //记得一定要写保存路径,如"H:\\text.pdf"
            document.save(outputFile);
            System.out.println("over");
        } finally {
            if (document != null) {
                document.close();
            }
        }
    }

}
