package PacoteDados;
public class Funcionario {
	String nomeFuncionario;
	String cargo;
	
	public Funcionario(String nomeFuncionario, String cargo){
		this.nomeFuncionario = nomeFuncionario;
		this.cargo = cargo;
	}
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}
	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}	
}
