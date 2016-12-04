package mx.cesarestudio.petagram.pojo;

/**
 * Created by cfvn0 on 11/7/2016.
 */
public class Mascota {
    private int imgMascota;
    private String nombre;
    private int numLikes;

    public Mascota(int imgMascota, String nombre, int numLikes) {
        this.imgMascota = imgMascota;
        this.nombre = nombre;
        this.numLikes = numLikes;
    }

    public int getImgMascota() {
        return imgMascota;
    }

    public void setImgMascota(int imgMascota) {
        this.imgMascota = imgMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumLikes() {
        return numLikes;
    }

    public void setNumLikes(int numLikes) {
        this.numLikes = numLikes;
    }
}
