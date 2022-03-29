package com.example.Design;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Icone {
    String pathOlhoAberto,pathOlhoFechado;
    BufferedImage bufImageOlhoAberto,bufImageOlhoFechado;
    java.awt.Image imgOlhoAberto,imgOlhoFechado;
    Icon iconeOlhoAberto, iconeOlhoFechado;
    int tam;

    public Icone() {
        tam = 24;
        pathOlhoAberto = "src\\main\\java\\com\\example\\Imagens\\olhoAberto.png";
        pathOlhoFechado = "src\\main\\java\\com\\example\\Imagens\\olhoFechado.png";
        try {
            bufImageOlhoAberto = ImageIO.read(new File(pathOlhoAberto));
            bufImageOlhoFechado = ImageIO.read(new File(pathOlhoFechado));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        imgOlhoAberto = bufImageOlhoAberto.getScaledInstance(tam,tam, 1);
        imgOlhoFechado = bufImageOlhoFechado.getScaledInstance(tam,tam,1);

        iconeOlhoAberto = new ImageIcon(imgOlhoAberto);
        iconeOlhoFechado = new ImageIcon(imgOlhoFechado);
    }

    public Icon getOlhoAberto() {
        return iconeOlhoAberto;
    }

    public Icon getOlhoFechado() {
        return iconeOlhoFechado;
    }
}
