package com.msb.dongbao.portal.web.code;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import lombok.Data;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Random;

/**
 * @author: Yunpeng Li
 * @date: 2021/7/14 11:38 上午
 */
@Data
public class ImageCode {
    private String code;
    private ByteArrayInputStream image;

    private final int width = 400;
    private final int height = 100;

    public static ImageCode getInstance() {
        return new ImageCode();
    }

    private ImageCode() {
        //图形缓冲区
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        // 给画笔
        Graphics graphics = image.getGraphics();

        //上色 画图
        graphics.setColor(new Color(255,255,255));

        graphics.fillRect(0,0,width,height);


        //font
        graphics.setFont(new Font("宋体",Font.PLAIN,30));

        //字就是随机数
        Random random = new Random();
        this.code = "";
        for(int i = 0; i < 6; i++) {
            String s = String.valueOf(random.nextInt(10));
            this.code += s;

            graphics.setColor(new Color(0,0,0));
            graphics.drawString(s,(width/6)*i,40);


            graphics.setColor(new Color(100,100,100));
            graphics.drawLine((width/6)*i,40,(width/6)*i+25,40-25);

        }

        for (int i = 0; i < 150; i++) {
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(20);
            int y2 = random.nextInt(20);
            graphics.drawLine(x1,y1,x1+x2,y1+y2);
        }

        //收笔
        graphics.dispose();



        ByteArrayInputStream inputStream = null;
        ByteOutputStream outputStream = new ByteOutputStream();
        //赋值给byteArrayInputStream
        try {
            ImageOutputStream imageOutputStream = ImageIO.createImageOutputStream(outputStream);
            ImageIO.write(image,"jpeg",imageOutputStream);

            inputStream = new ByteArrayInputStream(outputStream.toByteArray());


        } catch (IOException e) {
            System.out.println("生成验证码失败");
        }

        this.image = inputStream;

    }
}
