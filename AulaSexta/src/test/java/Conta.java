import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Conta {
	private boolean clienteEspecial;
	private float saldoAtualEspecial;
	private float saldoAtualComum;

	public void setClienteEspecial(boolean value) {
		this.clienteEspecial = value;
	}

	public boolean getClienteEspecial() {
		return this.clienteEspecial;
	}

	public void atualizarSaldoAtual(float valorDoSaque, boolean tipoCliente) {
		if (tipoCliente)
			this.saldoAtualEspecial -= valorDoSaque;
		else
			this.saldoAtualComum -= valorDoSaque;
	}

	public void setSaldoAtual(float value, boolean tipoCliente) {
		if (tipoCliente)
			this.saldoAtualEspecial = value;
		else
			this.saldoAtualComum = value;
	}

	public float getSaldoAtual(boolean tipoCliente) {
		if (tipoCliente)
			return this.saldoAtualEspecial;
		return this.saldoAtualComum;
	}

	// Método responsável por liberar ou não o saque
	public boolean sacar(float valorDoSaque, boolean tipoCliente) throws Exception {
		if (this.getSaldoAtual(tipoCliente) < valorDoSaque) {
			// 100 < 150
			if (tipoCliente) {
				// clienteEspecial = true;
				this.atualizarSaldoAtual(valorDoSaque, true);
				return true;
			} else
				// clienteEspecial = true; "cliente Comum"
				throw new Exception("Saldo Insuficiente");
		} else
			return true;
	}

	/**
	 *
	 * @param int1 - Esse é o primeiro e único parametro do tipo Inteiro
	 * @author - João Gomes
	 * 
	 */

	@Given("um cliente especial com saldo atual de {int} reais")
	public void um_cliente_especial_com_saldo_atual_de_reais(Integer int1) {
		this.setClienteEspecial(true);
		if (this.getClienteEspecial())
			this.setSaldoAtual(int1, this.clienteEspecial);
		else
			throw new io.cucumber.java.PendingException();
	}

	/**
	 *
	 * @param int1 - Esse é o primeiro e único parametro do tipo Inteiro
	 * @author - João Gomes
	 * 
	 */

	@When("for solicitado um saque no valor de {int} reais")
	public void for_solicitado_um_saque_no_valor_de_reais(Integer int1) {
		this.setClienteEspecial(true);
		if (this.getClienteEspecial())
			this.atualizarSaldoAtual(int1, clienteEspecial);
		else
			throw new io.cucumber.java.PendingException();

	}

	/**
	 *
	 * @param int1 - Esse é o primeiro e único parametro do tipo Inteiro
	 * @author - João Gomes
	 * 
	 */

	@Then("deve efetuar o saque e atualizar o saldo da conta para {int} reais")
	public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(Integer int1) {
		this.setClienteEspecial(true);
		if (this.getClienteEspecial()) {
			try {
				this.sacar(int1, clienteEspecial);
			} catch (Exception e) {
				System.out.println(e);
			}
		} else
			throw new io.cucumber.java.PendingException();

	}

	/**
	 *
	 * @param int1 - Esse é o primeiro e único parametro do tipo Inteiro
	 * @author - João Gomes
	 * 
	 */

	@Given("um cliente comum com saldo atual de {int} reais")
	public void um_cliente_comum_com_saldo_atual_de_reais(Integer int1) {
		this.setClienteEspecial(false);
		if (!this.getClienteEspecial())
			this.atualizarSaldoAtual(int1, clienteEspecial);
		else
			throw new io.cucumber.java.PendingException();
	}

	/**
	 *
	 * @param int1 - Esse é o primeiro e único parametro do tipo Inteiro
	 * @author - João Gomes
	 * 
	 */

	@When("solicitar um saque de {int} reais")
	public void solicitar_um_saque_de_reais(Integer int1) {
		this.setClienteEspecial(false);
		if (!this.getClienteEspecial())
			this.atualizarSaldoAtual(int1, clienteEspecial);
		else
			throw new io.cucumber.java.PendingException();
	}

	/**
	 *
	 * @param int1 - Esse é o primeiro e único parametro do tipo Inteiro
	 * @author - João Gomes
	 * 
	 */

	@Then("não deve efetuar o saque e deve retornar a mensagem Saldo Insuficiente")
	public void não_deve_efetuar_o_saque_e_deve_retornar_a_mensagem_saldo_insuficiente() {
//		this.setClienteEspecial(false);
//		if (!this.getClienteEspecial() && this.getSaldoAtual(false) < 0) {
//			System.out.println("Saldo Insulficiente");
//		} else
//			throw new io.cucumber.java.PendingException();
		if(this.getSaldoAtual(false) < 0)
			throw new io.cucumber.java.PendingException();

	}
}
