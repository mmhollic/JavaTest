package org.example;

public class Administrator {
    Patient pat1;
    MRIscan MRI1;
    BPexamination BP1;
    public Administrator(Patient pat1,MRIscan MRI1,BPexamination BP1){
        System.out.println("Patient: "+pat1.getName()+": MRI: "+MRI1.getFieldStrength()+"Tesla, "+MRI1.getMRIdate()+":BP : "+BP1.getDuration()+" , "+ BP1.getMeasurementDate());
    }

}
package org.example;

import java.time.LocalDate;

public class BPexamination {
    private int  sysPressure;
    private int diasPressure;
    private LocalDate measurementDate;
    private String duration;

    public BPexamination(int sysPressure,int diasPressure,LocalDate measurementDate,String duration){

        this.diasPressure=diasPressure;
        this.sysPressure=sysPressure;
        this.duration=duration;
        this.measurementDate=measurementDate;
    }

    public int getDiasPressure() {
        return diasPressure;
    }

    public int getSysPressure() {
        return sysPressure;
    }

    public LocalDate getMeasurementDate() {
        return measurementDate;
    }

    public String getDuration() {
        return duration;
    }
}
package org.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Display extends JPanel{

    Patient pat;
    MRIscan mri;
    BPexamination bp;
    public Display(Patient pat ) throws MalformedURLException {
        //setSize(600, 400);
      //  setBorder( new EmptyBorder(10, 10, 10, 10) ); // A nice margin
        //setLayout(new GridLayout(2,2));

        JLabel label=new JLabel();
        URL imageURL=null;
        imageURL = (pat.getPortrait());
        ImageIcon thisImageIcon = new ImageIcon(imageURL);
        label.setIcon(thisImageIcon);
        add(label);








    }
    public JLabel getDisplayMRI(MRIscan mri){
        JLabel label=new JLabel();
        URL imageURL=null;
        imageURL = (mri.getImageMRI());
        ImageIcon thisImageIcon = new ImageIcon(imageURL);
        label.setIcon(thisImageIcon);
        return label;
    }



}
package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws MalformedURLException {
        //GraphicsConfiguration gc = null;
       // JFrame f=new JFrame(gc);
        //f.setSize(500,300);
       // f.setVisible(true);

        Patient pat1 =new Patient("Daphne Von Oram ",62,new URL("https://martinh.netfirms.com/BIOE60010/DaphneVonOram.jpg"));
        MRIscan MRI1= new MRIscan(new URL("https://martinh.netfirms.com/BIOE60010/mri1.jpg"),2, LocalDate.of(2023,9,14));
        BPexamination BP1=new BPexamination(130,70,LocalDate.of(2023,9,15),"ST");
        Patient pat2 =new Patient("Sebastian Compton ",31,new URL("https://martinh.netfirms.com/BIOE60010/SebastianCompton.jpg"));
        MRIscan MRI2= new MRIscan(new URL("https://martinh.netfirms.com/BIOE60010/mri2.jpg"),4, LocalDate.of(2023,11,19));
        BPexamination BP2=new BPexamination(150,80,LocalDate.of(2023,11,20),"VST");
        Administrator ad= new Administrator(pat1,MRI1,BP1);
        Administrator ad2= new Administrator(pat2,MRI2,BP2);
        Display d=new Display(pat1);
        Display d2=new Display(pat2);
        JLabel d1m = d.getDisplayMRI(MRI1);

        //d1m.setLayout(new GridLayout(1,2));

        JLabel d2m=d2.getDisplayMRI(MRI2);
        JLabel text1=new JLabel();
        text1.setText("<html>Name:"+ pat1.getName()+"<br>Age:"+pat1.getAge()+"</html>");
        JLabel text2=new JLabel();
        text2.setText("<html>Name:"+ pat2.getName()+"<br>Age:"+pat2.getAge()+"</html>");
        JLabel text11=new JLabel();
        text11.setText("<html>Blood pressure"+ BP1.getSysPressure()+"<br>over:"+BP1.getDiasPressure()+"</html>");
        JLabel text22=new JLabel();
        text22.setText("<html>Blood pressure"+ BP2.getSysPressure()+"<br>over:"+BP2.getDiasPressure()+"</html>");
        //JPanel mainPanel=new JPanel();



        //mainPanel.add(label);



        JFrame frame = new JFrame();

        frame.setLayout(null);
        frame.setSize(5000, 3000);
        frame.setLayout(new GridLayout(2,4));
        frame.add(d);
        frame.add(d2);
        frame.add(d1m);
        frame.add(d2m);
        frame.add(text1);
        frame.add(text2);
        frame.add(text11);
        frame.add(text22);

        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    frame.dispose();
                }
            });
       // mainPanel.add(d).setVisible(true);
        //frame.add(mainPanel).setVisible(true);

        }
}
package org.example;

import java.net.URL;
import java.time.LocalDate;

public class MRIscan {
    private URL imageMRI;
    private int fieldStrength;
    private LocalDate MRIdate;
    public MRIscan(URL imageMRI,int fieldStrength,LocalDate MRIdate){
        this.imageMRI=imageMRI;
        this.fieldStrength=fieldStrength;
        this.MRIdate=MRIdate;

    }

    public int getFieldStrength() {
        return fieldStrength;
    }

    public LocalDate getMRIdate() {
        return MRIdate;
    }

    public URL getImageMRI() {
        return imageMRI;
    }
}
package org.example;

import java.net.URL;

public class Patient {
    private String name;
    private int age;
    private URL portrait=null;
    public Patient(String name,int age,URL portrait){
        this.name=name;
        this.age=age;
        this.portrait=portrait;

    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }

    public URL getPortrait() {
        return portrait;
    }
}
