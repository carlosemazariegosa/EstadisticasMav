/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package acad.managebean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.inject.Named;

/**
 *
 * @author mmarvin
 */
@Named
@javax.faces.view.ViewScoped
public class GalleriaBean implements Serializable {

    private List<String> images;
    private String foto;

    @PostConstruct
    public void init() {

        images = new ArrayList<String>();

        for (int i = 1; i <= 10; i++) {
            images.add("imagen" + i + ".jpg");

        }

        Random random = new Random();
        int num = random.nextInt(10);
        System.out.println(num);
        foto = images.get(num);
    }

    public List<String> getImages() {
        return images;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

}

