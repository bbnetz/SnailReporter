package eu.bbnetz;

import eu.bbnetz.Model.Csv;
import eu.bbnetz.Model.Customer;
import eu.bbnetz.Model.Settings;
import eu.bbnetz.Service.IdentifySnail;
import eu.bbnetz.Service.ReadCsv;
import eu.bbnetz.View.CliView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    protected ArrayList<Customer> customers;

	public static void main(String[] args) throws IOException{
        if(args.length == 0)
            showHelp();
        Main main = new Main(args);
	}

    protected static void showHelp() {
        System.out.println("Please read attached ReadMe.md for more Informations about usage!");
        throw new RuntimeException();
    }

    // TODO Documentation
    public Main(String[] args) throws IOException{
        System.out.print(CliView.render(this.readFileListAndSettings(args)));
    }

    protected  ArrayList<Customer> readFileListAndSettings(String[] args) throws IOException {
        ArrayList<File> files = new ArrayList<File>();
        for(String arg : args) {
            if(arg.startsWith("--")) {
                Settings.getInstance().setArgument(arg);
            }else{
                files.add(new File(arg));
            }
        }
        ArrayList<Customer> customers = new ArrayList<Customer>();
        for(File file:files) {
            customers = Main.mergeCustomerLists(customers, this.readCustomers(file));
        }
        return customers;
    }

    protected ArrayList<Customer> readCustomers(File file) throws IOException{
        Csv csv = ReadCsv.read(file);
        ArrayList<Customer> customers = IdentifySnail.read(csv);
        return customers;
    }

    /**
     *
     * @todo Merge lists
     * @param list1
     * @param list2
     * @return
     */
    protected static ArrayList<Customer> mergeCustomerLists(ArrayList<Customer> list1, ArrayList<Customer> list2) {
        return list2;
    }
}
