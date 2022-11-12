import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Conta {
	private boolean clienteEspecial = false;
	private float saldoAtualEspecial;
	private float saldoAtualComum;
	private Integer tenario;
	
	/**
	 * Método responsável pela inserção de estado do cliente.
	 * @author João Gomes
	 * @param value Boolean
	 */

	public void setClienteEspecial(boolean value) {
		this.clienteEspecial = value;
	}
	
	/**
	 * @author João Gomes
	 * @return Boolean - Informa-se o cliente é especial ou não.
	 */

	public boolean getClienteEspecial() {
		return this.clienteEspecial;
	}
	
	/**
	 * Método responsável pela atualização do saldo da conta do cliente. 
	 * @author João Gomes
	 * @param valorDoSaque Float
	 * @param tipoCliente Boolean
	 */

	public void atualizarSaldoAtual(float valorDoSaque, boolean tipoCliente) {
		if (tipoCliente)
			this.saldoAtualEspecial -= valorDoSaque;
		else
			this.saldoAtualComum -= valorDoSaque;
	}
	
	/**
	 * Método responsável pela inserção do saldo inicial da conta do cliente.
	 * @author João Gomes
	 * @param saldo Float
	 * @param tipoCliente Boolean
	 */

	public void setSaldoAtual(float saldo, boolean tipoCliente) {
		if (tipoCliente)
			this.saldoAtualEspecial = saldo;
		else
			this.saldoAtualComum = saldo;
	}
	
	/**
	 * Método responsável para puxar o saldo da conta do cliente. 
	 * @author João Gomes
	 * @param tipoCliente Boolean
	 * @return Float - Informa-se o saldo atual do cliente Especial ou Comum.
	 */

	public float getSaldoAtual(boolean tipoCliente) {
		if (tipoCliente)
			return this.saldoAtualEspecial;
		return this.saldoAtualComum;
	}
	
	/**
	 * Método utilizado apenas caso o Cliente seja Especial. Caso ele seja especial verifica-se se tem um valor
	 * sendo passado, caso nao tenha o valor por padrão é -200.
	 * @author João Gomes
	 * @param value Integer
	 */

	@Given("um cliente especial com saldo atual de {int} reais")
	public void um_cliente_especial_com_saldo_atual_de_reais(Integer value) {
		tenario  = (value > 0) ? value : -200;
		if (this.getClienteEspecial())
			this.setSaldoAtual(tenario, this.clienteEspecial);
		else
			throw new io.cucumber.java.PendingException();
	}

	/**
	 * Método utilizado apenas caso o Cliente seja Especial. Caso ele seja especial verifica-se se tem um valor
	 * sendo passado, caso nao tenha o valor por padrão é 100.
	 * @author João Gomes
	 * @param value Integer
	 */

	@When("for solicitado um saque no valor de {int} reais")
	public void for_solicitado_um_saque_no_valor_de_reais(Integer value) {
		tenario = (value > 0) ? value : 100;
		if (this.getClienteEspecial())
			this.atualizarSaldoAtual(tenario, clienteEspecial);
		else
			throw new io.cucumber.java.PendingException();

	}

	/**
	 * Método utilizado apenas caso o Cliente seja Especial. Caso ele seja especial verifica-se se tem um valor
	 * sendo passado, caso nao tenha o valor por padrão é -300.
	 * @author João Gomes
	 * @param value Integer
	 */
	
	@Then("deve efetuar o saque e atualizar o saldo da conta para {int} reais")
	public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(Integer value) {
		tenario = (value > 0 || value < 0) ? value : -300;
		
		if (this.getClienteEspecial()) {
			if (this.getSaldoAtual(this.getClienteEspecial()) <= tenario) { 
				this.atualizarSaldoAtual(tenario, this.getClienteEspecial());
			}
		} else
			throw new io.cucumber.java.PendingException();

	}

	/**
	 * Método utilizado apenas caso o Cliente seja Comum. Caso ele seja comum verifica-se se tem um valor
	 * sendo passado, caso nao tenha o valor por padrão é -300.
	 * @author João Gomes
	 * @param value Integer
	 */

	@Given("um cliente comum com saldo atual de {int} reais")
	public void um_cliente_comum_com_saldo_atual_de_reais(Integer value) {
		tenario  = (value > 0) ? value : -300;
		if (!this.getClienteEspecial())
			this.atualizarSaldoAtual(tenario, this.clienteEspecial);
		else
			throw new io.cucumber.java.PendingException();
	}

	/**
	 * Método utilizado apenas caso o Cliente seja Comum. Caso ele seja comum verifica-se se tem um valor
	 * sendo passado, caso nao tenha o valor por padrão é 200.
	 * @author João Gomes
	 * @param value Integer
	 */

	@When("solicitar um saque de {int} reais")
	public void solicitar_um_saque_de_reais(Integer value) {
		tenario = (value > 0) ? value : 200;
		if (!this.getClienteEspecial())
			this.atualizarSaldoAtual(tenario, clienteEspecial);
		else
			throw new io.cucumber.java.PendingException();
	}

	/**
	 * Método utilizado apenas caso o Cliente seja Comum.
	 * @author João Gomes
	 */

	@Then("não deve efetuar o saque e deve retornar a mensagem Saldo Insuficiente")
	public void não_deve_efetuar_o_saque_e_deve_retornar_a_mensagem_saldo_insuficiente() {
		if(!this.getClienteEspecial() && this.getSaldoAtual(this.getClienteEspecial()) < 0) {
			System.out.println("Saldo Insulficiente \n Seu saldo: " + this.getSaldoAtual(this.getClienteEspecial()));
			throw new io.cucumber.java.PendingException();
		}
	}
}
