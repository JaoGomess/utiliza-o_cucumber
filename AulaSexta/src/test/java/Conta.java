import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Conta {
	private boolean clienteEspecial = false;
	private float saldoAtualEspecial;
	private float saldoAtualComum;
	private Integer tenario;
	
	/**
	 * @author João Gomes
	 * @method setClienteEspecial()
	 * @description Represeta o valor se o cliente é especial ou não.
	 * @param value (boolean)
	 * 
	 */

	public void setClienteEspecial(boolean value) {
		this.clienteEspecial = value;
	}
	
	/**
	 * @author João Gomes
	 * @method getClienteEspecial()
	 * @description Metodo usado para mostrar se o cliente é especial ou não.  
	 * 
	 */

	public boolean getClienteEspecial() {
		return this.clienteEspecial;
	}
	
	/**
	 * @author João Gomes
	 * @method atualizarSaldoAtual()
	 * @description Metodo usado para atualizar o saldo da conta do cliente, sendo ele especial ou nao.  
	 * @params valorDoSaque (float) e tipoCliente (boolean)
	 * 
	 */

	public void atualizarSaldoAtual(float valorDoSaque, boolean tipoCliente) {
		if (tipoCliente)
			this.saldoAtualEspecial -= valorDoSaque;
		else
			this.saldoAtualComum -= valorDoSaque;
	}
	
	/**
	 * @author João Gomes
	 * @method setSaldoAtual()
	 * @description Metodo usado para inserir o saldo inicial da conta do cliente, sendo ele especial ou nao.  
	 * @params value (float) e tipoCliente (boolean)
	 * 
	 */

	public void setSaldoAtual(float value, boolean tipoCliente) {
		if (tipoCliente)
			this.saldoAtualEspecial = value;
		else
			this.saldoAtualComum = value;
	}
	
	/**
	 * @author João Gomes
	 * @method getSaldoAtual()
	 * @description Metodo usado para verificar o saldo da conta do cliente, sendo ele especial ou nao.  
	 * @params tipoCliente (boolean)
	 * 
	 */

	public float getSaldoAtual(boolean tipoCliente) {
		if (tipoCliente)
			return this.saldoAtualEspecial;
		return this.saldoAtualComum;
	}
	
	/**
	 * @author João Gomes
	 * @method um_cliente_especial_com_saldo_atual_de_reais()
	 * @description Esse metodo é usado caso o cliente seja especial, logo verifica-se se tem um valor
	 * sendo passado nele, caso nao tenha o valor por padrão é -200.
	 * @params int1 (Integer)
	 * 
	 */

	@Given("um cliente especial com saldo atual de {int} reais")
	public void um_cliente_especial_com_saldo_atual_de_reais(Integer int1) {
		tenario  = (int1 > 0) ? int1 : -200;
		if (this.getClienteEspecial())
			this.setSaldoAtual(tenario, this.clienteEspecial);
		else
			throw new io.cucumber.java.PendingException();
	}

	/**
	 * @author João Gomes
	 * @method for_solicitado_um_saque_no_valor_de_reais()
	 * @description Esse metodo é usado caso o cliente seja especial, logo verifica-se se tem um valor
	 * sendo passado nele, caso nao tenha o valor por padrão é 100.
	 * @params int1 (Integer)
	 * 
	 */

	@When("for solicitado um saque no valor de {int} reais")
	public void for_solicitado_um_saque_no_valor_de_reais(Integer int1) {
		tenario = (int1 > 0) ? int1 : 100;
		if (this.getClienteEspecial())
			this.atualizarSaldoAtual(tenario, clienteEspecial);
		else
			throw new io.cucumber.java.PendingException();

	}

	/**
	 * @author João Gomes
	 * @method deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais()
	 * @description Esse metodo é usado caso o cliente seja especial, logo verifica-se se tem um valor
	 * sendo passado nele, caso nao tenha o valor por padrão é -300.
	 * @params int1 (Integer)
	 * 
	 */
	
	@Then("deve efetuar o saque e atualizar o saldo da conta para {int} reais")
	public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(Integer int1) {
		tenario = (int1 > 0 || int1 < 0) ? int1 : -300;
		
		if (this.getClienteEspecial()) {
			if (this.getSaldoAtual(this.getClienteEspecial()) <= tenario) { 
				this.atualizarSaldoAtual(tenario, this.getClienteEspecial());
			}
		} else
			throw new io.cucumber.java.PendingException();

	}

	/**
	 * @author João Gomes
	 * @method um_cliente_comum_com_saldo_atual_de_reais()
	 * @description Esse metodo é usado caso o cliente seja comum, logo verifica-se se tem um valor
	 * sendo passado nele, caso nao tenha o valor por padrão é -300.
	 * @params int1 (Integer)
	 * 
	 */

	@Given("um cliente comum com saldo atual de {int} reais")
	public void um_cliente_comum_com_saldo_atual_de_reais(Integer int1) {
		tenario  = (int1 > 0) ? int1 : -300;
		if (!this.getClienteEspecial())
			this.atualizarSaldoAtual(tenario, this.clienteEspecial);
		else
			throw new io.cucumber.java.PendingException();
	}

	/**
	 * @author João Gomes
	 * @method solicitar_um_saque_de_reais()
	 * @description Esse metodo é usado caso o cliente seja comum, logo verifica-se se tem um valor
	 * sendo passado nele, caso nao tenha o valor por padrão é 200.
	 * @params int1 (Integer)
	 * 
	 */

	@When("solicitar um saque de {int} reais")
	public void solicitar_um_saque_de_reais(Integer int1) {
		tenario = (int1 > 0) ? int1 : 200;
		if (!this.getClienteEspecial())
			this.atualizarSaldoAtual(tenario, clienteEspecial);
		else
			throw new io.cucumber.java.PendingException();
	}

	/**
	 * @author João Gomes
	 * @method não_deve_efetuar_o_saque_e_deve_retornar_a_mensagem_saldo_insuficiente()
	 * @description Esse metodo é usado caso o cliente seja comum e que o saldo dele seja menor que 0, caso seja,
	 * informa-se que o saldo é insulficiente e mostra o saldo do cliente.
	 * 
	 */

	@Then("não deve efetuar o saque e deve retornar a mensagem Saldo Insuficiente")
	public void não_deve_efetuar_o_saque_e_deve_retornar_a_mensagem_saldo_insuficiente() {
		if(!this.getClienteEspecial() && this.getSaldoAtual(this.getClienteEspecial()) < 0) {
			System.out.println("Saldo Insulficiente \n Seu saldo: " + this.getSaldoAtual(this.getClienteEspecial()));
			throw new io.cucumber.java.PendingException();
		}
		

	}
}
