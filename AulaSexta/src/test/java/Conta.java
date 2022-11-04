import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class Conta {
    public int saldo;
    public int saque;
	
	/**
	 *
	 * @param valor - Esse é o primeiro e único parametro do tipo Inteiro
         * @author - João Gomes
         * 
	 */

	@Given("um cliente especial com saldo atual de {int} reais")
	public void um_cliente_especial_com_saldo_atual_de_reais(Integer valor) {
        this.saldo = valor;
        if (this.saldo != - 200)
            throw new io.cucumber.java.PendingException();
	}
	
	/**
	 *
	 * @param valor - Esse é o primeiro e único parametro do tipo Inteiro
         * @author - João Gomes
         * 
	 */

	@When("for solicitado um saque no valor de {int} reais")
	public void for_solicitado_um_saque_no_valor_de_reais(Integer valor) {
	    this.saque = valor;
	    if (this.saque != 100) 
	    	throw new io.cucumber.java.PendingException();
	}
	
	/**
	 *
	 * @param valor - Esse é o primeiro e único parametro do tipo Inteiro
         * @author - João Gomes
         * 
	 */

	@Then("deve efetuar o saque e atualizar o saldo da conta para {int} reais")
	public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(Integer valor) {
		if ((this.saldo - this.saque) == -300) 
	    	this.saldo = valor;
		else 
	    	throw new io.cucumber.java.PendingException();
	}
	
	/**
	 *
	 * @param valor - Esse é o primeiro e único parametro do tipo Inteiro
         * @author - João Gomes
         * 
	 */

	@Given("um cliente comum com saldo atual de {int} reais")
	public void um_cliente_comum_com_saldo_atual_de_reais(Integer valor) {
	    this.saldo = valor;
	    if (this.saldo != -300) 
	    	throw new io.cucumber.java.PendingException();
	}
	
	/**
	 *
	 * @param valor - Esse é o primeiro e único parametro do tipo Inteiro
         * @author - João Gomes
         * 
	 */

	@When("solicitar um saque de {int} reais")
	public void solicitar_um_saque_de_reais(Integer valor) {
	    this.saque = valor;
	    if (this.saque != -100) 
	    	throw new io.cucumber.java.PendingException();
	}
	
	/**
	 *
	 * @param valor - Esse é o primeiro e único parametro do tipo Inteiro
         * @author - João Gomes
         * 
	 */

	@Then("não deve efetuar o saque e deve retornar a mensagem Saldo Insuficiente")
	public void não_deve_efetuar_o_saque_e_deve_retornar_a_mensagem_saldo_insuficiente() {
		if (this.saldo < 0) 
			System.out.println("Saldo Insuficiente");
		else 
			throw new io.cucumber.java.PendingException();
	}
}
