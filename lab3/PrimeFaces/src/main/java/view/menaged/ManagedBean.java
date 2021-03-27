/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.menaged;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.line.LineChartDataSet;

/**
 *
 * @author alili
 */
@Named(value = "managedBean")
@RequestScoped
public class ManagedBean {
    private String result;
    private int add1;
    private int add2;
    private ArrayList<Student> students = new ArrayList<>();
    private LineChartModel lineModel;
    /**
     * Creates a new instance of ManagedBean
     */
    public ManagedBean() {
        fillStudents();
        createLineModel();
    }
    
    public String getCurrentDateTime(){
        return new java.util.Date().toString();
    }
        
    public void calculate(){
        result = "= " + String.valueOf(add1 + add2);
    }
    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }
    public void growlInfo() {
        String growlMessage = String.valueOf(add1)+" + "+String.valueOf(add2)+" = "+String.valueOf(add1 + add2);
        addMessage(FacesMessage.SEVERITY_INFO, "Poprzednie działanie:", growlMessage);
    }
    
    private void fillStudents(){
        getStudents().add(new Student("Alex", "Lis", 5.0));
        getStudents().add(new Student("Bart", "Man", 4.5));
        getStudents().add(new Student("Cris", "Neu", 4.0));
        getStudents().add(new Student("Derk", "Ost", 3.5));
        getStudents().add(new Student("Elie", "Pat", 3.0));
    }
    
    public void createLineModel() {
        setLineModel(new LineChartModel());
        LineChartSeries sin = new LineChartSeries();
        LineChartSeries cos = new LineChartSeries();
        
        sin.setLabel("Sine");
        cos.setLabel("Cosine");
        
        for(double i=0; i<=360; i+=10){
            sin.set(i, Math.sin(Math.toRadians(i)));
            cos.set(i, Math.cos(Math.toRadians(i)));
        }
        
        getLineModel().setTitle("Sine and Cosine");
        getLineModel().addSeries(sin);
        getLineModel().addSeries(cos);
        
        getLineModel().setZoom(true); 
    }
    
    /**
     * @return the result
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * @return the add1
     */
    public int getAdd1() {
        return add1;
    }

    /**
     * @param add1 the add1 to set
     */
    public void setAdd1(int add1) {
        this.add1 = add1;
    }

    /**
     * @return the add2
     */
    public int getAdd2() {
        return add2;
    }

    /**
     * @param add2 the add2 to set
     */
    public void setAdd2(int add2) {
        this.add2 = add2;
    }

    /**
     * @return the students
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * @param students the students to set
     */
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    /**
     * @return the lineModel
     */
    public LineChartModel getLineModel() {
        return lineModel;
    }

    /**
     * @param lineModel the lineModel to set
     */
    public void setLineModel(LineChartModel lineModel) {
        this.lineModel = lineModel;
    }
    
}
