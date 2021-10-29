import java.util.ArrayList;

public class Fisc 
{
	private ArrayList<Client> fisc = new ArrayList<>();
	
	public Fisc(ArrayList<Client> fisc)
	{
		this.fisc = fisc;
	}
	
	public ArrayList<Client> getFisc()
	{
		return this.fisc;
	}
	
	public void addClient(Client client, long clientCNP)
	{
		String name = client.getName();
		long CNP = client.getCNP();
		float sold_euro = client.getSold_cont_euro();
		float sold_ron = client.getSold_cont_ron();
		String pinEuro = client.changePin(client.getPinEuro());
		String pinRon = client.changePin(client.getPinRon());
		
		if(client.getCNP() == clientCNP)
		{
			client = new Client(name, CNP, sold_euro, sold_ron, pinEuro, pinRon);
			this.fisc.add(client);
		}
	}
	
	public Boolean removeClient(long CNP)
	{
		for(Client client : this.fisc)
		{
			if(CNP == client.getCNP())
				return fisc.remove(client);	
		}
		return false;
	}
	
	public Boolean cnpValidation(long CNP)
	 {
		 for(Client client : this.fisc)
	       if(client.getCNP() == CNP)
	           return true;
	       
	       return false;
	 }
	
	public void showClientDetails(long CNP)
	{
		for(Client client : fisc)
			if(CNP == client.getCNP())
			{	
				System.out.println("Client name is: " + client.getName());
				System.out.println("Client CNP is: " + client.getCNP());
				System.out.println("Client sold in euro is: " + client.getSold_cont_euro());
				System.out.println("Client sold in ron is: " + client.getSold_cont_ron());
				System.out.println("Client pin euro is: " + client.getPinEuro());
				System.out.println("Client pin ron is: " + client.getPinRon());
			}
	}
	
}
