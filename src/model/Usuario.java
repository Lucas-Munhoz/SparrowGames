package model;

public class Usuario {
    
    private int idUsuario;

    private String imgUsuario;

    private String nomeUsuario;

    private String emailUsuario;

    private String senhaUsuario;

    private Boolean verAdmin;

    private String codRec;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getImgUsuario() {
        return imgUsuario;
    }

    public void setImgUsuario(String imgUsuario) {
        this.imgUsuario = imgUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuaio) {
        this.nomeUsuario = nomeUsuaio;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public Boolean getVerAdmin() {
        return verAdmin;
    }

    public void setVerAdmin(Boolean verAdmin) {
        this.verAdmin = verAdmin;
    }

    public String getCodRec() {
        return codRec;
    }

    public void setCodRec(String codRec) {
        this.codRec = codRec;
    }
}
