package ai.beans;

public class ColorBean {

    private String foregroundColor;
    private String backgroundColor;
    private String borders;
    
    public ColorBean() {
    }

    /**
     * @return the foregroundColor
     */
    public String getForegroundColor() {
        return foregroundColor;
    }

    /**
     * @param foregroundColor the foregroundColor to set
     */
    public void setForegroundColor(String foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    /**
     * @return the backgroundColor
     */
    public String getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * @param backgroundColor the backgroundColor to set
     */
    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    /**
     * @return the borders
     */
    public String getBorders() {
        return borders;
    }

    /**
     * @param borders the borders to set
     */
    public void setBorders(String borders) {
        if(borders.equals("tak"))
            this.borders = "border";
        else
            this.borders = "";
    }
}
