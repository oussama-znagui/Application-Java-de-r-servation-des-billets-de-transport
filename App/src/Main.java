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


      //  Partner allo = new Partner(1,"allo","045389","dze",'d', Transport.BUS,PartnerStatus.ACTIVE,"12/12/2022");
        Partner allo2 = new Partner();
//        System.out.println(allo.getCompanyName());
//        Contract salus = new Contract(1,"12/12/12","12/12/12",12,"zelfzek zel zpeo ", true , ContratStatus.FINISHED,allo);
//
//        System.out.println(salus.getPartner().getCreationDate());

//        mainMenu.menu();

        PartnerRepository.addPartner(allo2);
        PartnerRepository partnerRepository = new PartnerRepository();
        //partnerRepository.deletePartner(allo2);
        Partner allo3 = new Partner(0,"goloto","0103040566","europe","a remlir PT",Transport.TRAIN,PartnerStatus.ACTIVE,"12/12/2022");
        partnerRepository.updatePartner(allo2,allo3);
        PartnerRepository.displayAllPartners();
         Partner hey = partnerRepository.getPartnerById(3);
        System.out.println(hey.getCreationDate());






    }


}
