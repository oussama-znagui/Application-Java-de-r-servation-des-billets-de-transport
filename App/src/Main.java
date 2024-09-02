import Config.Dbconnexion;
import Model.Contract;
import Model.Partner;
import Enum.Transport;
import Enum.PartnerStatus;
import  Enum.ContratStatus;
import Repository.PartnerRepository;
import UI.mainMenu;


import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Dbconnexion.getConnection();


//        Partner allo = new Partner(1,"allo","045389", Transport.BUS,PartnerStatus.ACTIVE,"12/12/2022");
//        System.out.println(allo.getCompanyName());
//        Contract salus = new Contract(1,"12/12/12","12/12/12",12,"zelfzek zel zpeo ", true , ContratStatus.FINISHED,allo);
//
//        System.out.println(salus.getPartner().getCreationDate());

//        mainMenu.menu();
        PartnerRepository.getAllPartners();


    }


}
