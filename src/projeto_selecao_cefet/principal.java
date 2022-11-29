package projeto_selecao_cefet;

import java.util.Scanner;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;


class Funcionarios{
	String nome;
	String cargo;
	Date data_contratacao;
	
	Funcionarios(String nome, String cargo, Date data_contratacao){
		this.nome=nome;
		this.cargo=cargo;
		this.data_contratacao=data_contratacao;
	}
	
	public String getNome() {
		return this.nome;
	}
	public String getCargo() {
		return this.cargo;
	}
	public Date getData_contratacao() {
		return this.data_contratacao;
	}

	public float Salario(ArrayList<Funcionarios> funcionarios) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}




public class principal {
	

	public static void main(String[] args) throws ParseException {
		
		
		ArrayList<Funcionarios> funcionarios = new ArrayList<Funcionarios>();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/yyyy");
		
		funcionarios.add(new Funcionarios("Jorge Carvalho", "Secretario", formatter.parse("01/2018")));
		funcionarios.add(new Funcionarios("Maria Souza", "Secretario", formatter.parse("12/2015")));
		funcionarios.add(new Funcionarios("Ana Silva", "Vendedor", formatter.parse("12/2021")));
		funcionarios.add(new Funcionarios("João", "Vendedor", formatter.parse("12/2021")));
		funcionarios.add(new Funcionarios("Ana Silva", "Vendedor", formatter.parse("12/2021")));
		funcionarios.add(new Funcionarios("Juliana Alves", "Gerente", formatter.parse("07/2017")));
		funcionarios.add(new Funcionarios("Bento Albino", "Gerente", formatter.parse("03/2014")));
		
		
		System.out.print("Salario total dos funcionarios: ");
		System.out.println(Salario(funcionarios));
		System.out.print("Salario total dos funcionarios sem benefício: ");
		System.out.println(PagamentoMes(funcionarios));
		System.out.print("Total de benefício pago: ");
		System.out.println(FuncBeneficiado(funcionarios));

	}
	
	public static double Salario(ArrayList<Funcionarios> funcionarios){
		ArrayList<Float> salarios = new ArrayList<Float>();
		
		funcionarios.forEach(e->{
			Period diff;
			if(e.getCargo().equals("Secretario")) {	
				diff  = Period.between(e.getData_contratacao().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now());
				salarios.add((float)((diff.getYears()*1000 + 7000 )*120/100));
			}
			if(e.getCargo().equals("Vendedor")) {	
				diff  = Period.between(e.getData_contratacao().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now());
				salarios.add((float)((diff.getYears()*1800 + 12000 )*130/100));
			}
			if(e.getCargo().equals("Gerente")) {	
				diff  = Period.between(e.getData_contratacao().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now());
				salarios.add((float)((diff.getYears()*3000 + 20000)));
			}
		});
		
		
		return salarios.stream().mapToDouble(Float::doubleValue).sum();
	}
	
	public static double PagamentoMes(ArrayList<Funcionarios> funcionarios){
		ArrayList<Float> salarios = new ArrayList<Float>();
		
		funcionarios.forEach(e->{
			Period diff;
			if(e.getCargo().equals("Secretario")) {	
				diff  = Period.between(e.getData_contratacao().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now());
				salarios.add((float)((diff.getYears()*1000 + 7000)));
			}
			if(e.getCargo().equals("Vendedor")) {	
				diff  = Period.between(e.getData_contratacao().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now());
				salarios.add((float)((diff.getYears()*1800 + 12000)));
			}
			if(e.getCargo().equals("Gerente")) {	
				diff  = Period.between(e.getData_contratacao().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now());
				salarios.add((float)((diff.getYears()*3000 + 20000)));
			}
		});
		
		
		return salarios.stream().mapToDouble(Float::doubleValue).sum();
	}
	
	public static double FuncBeneficiado(ArrayList<Funcionarios> funcionarios){
		ArrayList<Float> salarios = new ArrayList<Float>();
		
		funcionarios.forEach(e->{
			Period diff;
			if(e.getCargo().equals("Secretario")) {	
				diff  = Period.between(e.getData_contratacao().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now());
				salarios.add((float)(((diff.getYears()*1000 + 7000 )*120/100)/1.2));
			}
			if(e.getCargo().equals("Vendedor")) {	
				diff  = Period.between(e.getData_contratacao().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now());
				salarios.add((float)(((diff.getYears()*1800 + 12000)*130/100)/1.3));
				
			}		
		});
		
		
		return salarios.stream().mapToDouble(Float::doubleValue).sum();
	}
	
}
