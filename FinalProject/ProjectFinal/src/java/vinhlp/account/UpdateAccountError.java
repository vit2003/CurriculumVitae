/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinhlp.account;

/**
 *
 * @author Asus
 */
public class UpdateAccountError {
    
    private String passwordLegthErr;
    private String unAdminErr;
    private String changeCurrentAccountErr;
    private String updateDatabaseErr;
    private String nullAddressErr;
    
    public UpdateAccountError() {
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
     * @return the unAdminErr
     */
    public String getUnAdminErr() {
        return unAdminErr;
    }

    /**
     * @param unAdminErr the unAdminErr to set
     */
    public void setUnAdminErr(String unAdminErr) {
        this.unAdminErr = unAdminErr;
    }

    /**
     * @return the changeCurrentAccountErr
     */
    public String getChangeCurrentAccountErr() {
        return changeCurrentAccountErr;
    }

    /**
     * @param changeCurrentAccountErr the changeCurrentAccountErr to set
     */
    public void setChangeCurrentAccountErr(String changeCurrentAccountErr) {
        this.changeCurrentAccountErr = changeCurrentAccountErr;
    }

    /**
     * @return the updateDatabaseErr
     */
    public String getUpdateDatabaseErr() {
        return updateDatabaseErr;
    }

    /**
     * @param updateDatabaseErr the updateDatabaseErr to set
     */
    public void setUpdateDatabaseErr(String updateDatabaseErr) {
        this.updateDatabaseErr = updateDatabaseErr;
    }

    /**
     * @return the nullAddressErr
     */
    public String getNullAddressErr() {
        return nullAddressErr;
    }

    /**
     * @param nullAddressErr the nullAddressErr to set
     */
    public void setNullAddressErr(String nullAddressErr) {
        this.nullAddressErr = nullAddressErr;
    }
    
    
}
