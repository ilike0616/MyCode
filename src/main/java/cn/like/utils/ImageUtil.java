package cn.like.utils;

import cn.like.study.image.DrawConfig;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

/**
 * @program: MyCode
 * @description:
 * @author: 21936944@qq.com(ilike)
 * @create: 2019-09-04 11:35
 **/
public class ImageUtil {

    /**
     * @param srcImgPath       源图片路径
     * @param tarImgPath       保存的图片路径
     */
    public void addWaterMark(String srcImgPath, String tarImgPath, DrawConfig draw) {
        try {
            // 读取原图片信息
            File srcImgFile = new File(srcImgPath);//得到文件
            Image srcImg = ImageIO.read(srcImgFile);//文件转化为图片
            int srcImgWidth = srcImg.getWidth(null);//获取图片的宽
            int srcImgHeight = srcImg.getHeight(null);//获取图片的高
            // 加水印
            BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufImg.createGraphics();
            g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
            g.setColor(draw.getColor()); //根据图片的背景设置水印颜色
            g.setFont(draw.getFont());              //设置字体

            g.drawString(draw.getContent(), draw.getX(), draw.getY());  //画出水印
            g.dispose();
            // 输出图片
            FileOutputStream outImgStream = new FileOutputStream(tarImgPath);
            ImageIO.write(bufImg, "jpg", outImgStream);
            System.out.println("添加水印完成");
            outImgStream.flush();
            outImgStream.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public int getWatermarkLength(String waterMarkContent, Graphics2D g) {
        return g.getFontMetrics(g.getFont()).charsWidth(waterMarkContent.toCharArray(), 0, waterMarkContent.length());
    }

    public static void main(String[] args) {
        DrawConfig draw = new DrawConfig();
        draw.setFont(new Font("微软雅黑", Font.PLAIN, 35));  //水印字体
        draw.setColor(new Color(0, 0, 0, 255));
        draw.setX(370);
        draw.setY(565);
        draw.setContent("李珂");
        String srcImgPath = "/Users/ilike/Pictures/page_1.jpg"; //源图片地址
        String tarImgPath = "/Users/ilike/Pictures/page_1_.jpg"; //待存储的地址
        new ImageUtil().addWaterMark(srcImgPath, tarImgPath, draw);

    }
}
