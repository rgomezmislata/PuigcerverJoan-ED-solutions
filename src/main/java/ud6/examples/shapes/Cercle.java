package ud6.examples.shapes;

/**
 * Aquesta classe representa un cercle posicionat en l'espai de coordenades X i Y.
 * 
 * @author Joan Puigcerver
 * @version 1.3 2023-01-13
 */
public class Cercle extends Shape {
    /**
     * El radi del Cercle.
     */
    protected int radius;
    /**
     * Crea un Cercle a partir del radi i la posició del centre.
     * @param radius Radi del Cercle
     * @param x Posició del centre del Cercle en l'eix X
     * @param y Posició del centre del Cercle en l'eix Y
     */
    public Cercle(int radius, int x, int y) {
        super(x, y);
        this.radius = radius;
    }

    public Cercle(int radius, int x, int y, Color color) {
        super(x, y, color);
        this.radius = radius;
    }

    /**
     * Crea un Cercle en l'origen de coordenades (0, 0) amb el radi especificat
     * @param radius Radi del Cercle
     */
    public Cercle(int radius) {
        super();
        this.radius = radius;
    }

    public Cercle(int radius, Color color) {
        super(color);
        this.radius = radius;
    }

    /**
     * Crea un Cercle a partir d'un altre Cercle
     * @param other Cercle que serà copiat
     */
    public Cercle(Cercle other) {
        super(other);
        this.radius = other.getRadius();
    }

    /**
     * Obté el radi del Cercle
     * @return Radi del cercle
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Estableix el radi del Cercle
     * @param radius Nou radi del Cercle
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    /**
     * Calcula el àrea del Cercle
     * @return Àrea del cercle
     * @since 1.1
     */
    public double area(){
        return Math.PI * Math.pow(this.radius, 2);
    }

    /**
     * Comprova si el punt especificat (x, y) està dins del Cercle.
     * @param x Coordeneda del punt especificat en l'eix X.
     * @param y Coordeneda del punt especificat en l'eix Y.
     * @return True si el punt (x, y) està dins del Cercle, False en altre cas.
     * @since 1.2
     */
    public boolean contains(double x, double y){
        double distance = Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
        return distance <= radius;
    }

    /**
     * Retorna una còpia del cercle
     * @return Còpia del cercle
     */
    public Cercle clone(){
        return new Cercle(this);
    }

    public void draw(){
        int diameter = radius * 2;
        int centreX = radius;
        int centreY = radius;
        for (int i = 0; i < diameter; i++) {
            for (int j = 0; j < diameter; j++) {
                double puntX = j + 0.5;
                double puntY = i + 0.5;
                double distance = Math.sqrt(Math.pow(puntX - centreX, 2) + Math.pow(puntY - centreY, 2));
                System.out.print(distance >= radius ? " " : "█");
            }
            System.out.println();
        }
    }

}
