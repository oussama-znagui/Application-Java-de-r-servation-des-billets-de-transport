import Config.Dbconnexion;
import Model.Contract;
import Model.Partner;
import Enum.Transport;
import Enum.PartnerStatus;
import Enum.ContractStatus;
import Repository.ContractRepository;
import UI.mainMenu;


import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException {



      //  Partner allo = new Partner(1,"allo","045389","dze",'d', Transport.BUS,PartnerStatus.ACTIVE,"12/12/2022");
        Partner allo2 = new Partner();
//        System.out.println(allo.getCompanyName());
//        Contract salus = new Contract(1,"12/12/12","12/12/12",12,"zelfzek zel zpeo ", true , ContratStatus.FINISHED,allo);
//
//        System.out.println(salus.getPartner().getCreationDate());

//        mainMenu.menu();

//        PartnerRepository.addPartner(allo2);
//        PartnerRepository partnerRepository = new PartnerRepository();
//        //partnerRepository.deletePartner(allo2);
//        Partner allo3 = new Partner(0,"goloto","0103040566","europe","a remlir PT",Transport.TRAIN,PartnerStatus.ACTIVE,"12/12/2022");
//        partnerRepository.updatePartner(allo2,allo3);
//        PartnerRepository.displayAllPartners();
//         Partner hey = partnerRepository.getPartnerById(3);
//        System.out.println(hey);


//        Partner RayanAir = new Partner(3,"rayan air","0123483309","MENA & EUROPE","a remplir",Transport.AIRPLANE,PartnerStatus.ACTIVE,"03/09/2024");
//        Contract contract = new Contract(0, LocalDate.parse("2020-01-08"),LocalDate.parse("2020-01-08"),13,"a remlir",true, ContractStatus.ONGOING,RayanAir);
        ContractRepository contractRepository = new ContractRepository();
//        if (contractRepository.addContract(contract)){
//            System.out.println("Contract added");
//        }

//        contractRepository.displayAllContracts();

//
     mainMenu.pricipaleMenu();
//
//        Contract contract = contractRepository.getContractById(3);
//
//
//    System.out.println(contract.getPartner());





    }


}
