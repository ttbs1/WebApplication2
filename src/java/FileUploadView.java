/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author aluno1
 */
@ManagedBean(name = "fileUploadView")
@ViewScoped
public class FileUploadView {

    private FileUploadView file;
    private String x;
    public FileUploadView getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = (FileUploadView) file;
    }
     
    public void upload() {
        if(file != null) {
            FacesMessage message = new FacesMessage("Succesful", file.getFile() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
     
    public String handleFileUpload(FileUploadEvent event) throws FileNotFoundException, IOException {
        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        String x = new Scanner(event.getFile().getInputstream(),"UTF-8").useDelimiter("\\A").next();
        return x;
    }
    
    public FileUploadView() {
        
    }
    
}
