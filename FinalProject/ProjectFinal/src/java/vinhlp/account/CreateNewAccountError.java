/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinhlp.account;

import java.io.Serializable;

/**
 *
 * @author Asus
 */
public class CreateNewAccountError implements Serializable{
    
    private String usernameLegthErr;
    private String passwordLegthErr;
    private String confirmWrongErr;
    private String fullnameLegthErr;
    private String addressLegthErr;
    private String duplacateAccountErr;

    public CreateNewAccountError() {
    }

    public CreateNewAccountError(String usernameLegthErr, String passwordLegthErr, String confirmWrongErr, String fullnameLegthErr, String addressLegthErr, String duplacateAccountErr) {
        this.usernameLegthErr = usernameLegthErr;
        this.passwordLegthErr = passwordLegthErr;
        this.confirmWrongErr = confirmWrongErr;
        this.fullnameLegthErr = fullnameLegthErr;
        this.addressLegthErr = addressLegthErr;
        this.duplacateAccountErr = duplacateAccountErr;
    }

    /**
     * @return the usernameLegthErr
     */
    public String getUsernameLegthErr() {
        return usernameLegthErr;
    }

    /**
     * @param usernameLegthErr the usernameLegthErr to set
     */
    public void setUsernameLegthErr(String usernameLegthErr) {
        this.usernameLegthErr = usernameLegthErr;
    }

    /**
     * @return the passwordLegthErr
     */
    public String getPasswordLegthErr() {
        return passwordLegthErr;
    }

    /**
     * @param passwordLegthErr the passwordLegthErr to set
     */
    public void setPasswordLegthErr(String passwordLegthErr) {
        this.passwordLegthErr = passwordLegthErr;
    }

    /**
     * @return the confirmWrongErr
     */
    public String getConfirmWrongErr() {
        return confirmWrongErr;
    }

    /**
     * @param confirmWrongErr the confirmWrongErr to set
     */
    public void setConfirmWrongErr(String confirmWrongErr) {
        this.confirmWrongErr = confirmWrongErr;
    }

    /**
     * @return the fullnameLegthErr
     */
    public String getFullnameLegthErr() {
        return fullnameLegthErr;
    }

    /**
     * @param fullnameLegthErr the fullnameLegthErr to set
     */
    public void setFullnameLegthErr(String fullnameLegthErr) {
        this.fullnameLegthErr = fullnameLegthErr;
    }

    /**
     * @return the addressLegthErr
     */
    public String getAddressLegthErr() {
        return addressLegthErr;
    }

    /**
     * @param addressLegthErr the addressLegthErr to set
     */
    public void setAddressLegthErr(String addressLegthErr) {
        this.addressLegthErr = addressLegthErr;
    }

    /**
     * @return the duplacateAccountErr
     */
    public String getDuplacateAccountErr() {
        return duplacateAccountErr;
    }

    /**
     * @param duplacateAccountErr the duplacateAccountErr to set
     */
    public void setDuplacateAccountErr(String duplacateAccountErr) {
        this.duplacateAccountErr = duplacateAccountErr;
    }
    
    
}
