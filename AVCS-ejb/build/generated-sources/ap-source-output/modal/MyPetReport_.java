package modal;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modal.MyAppointments;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-04-29T14:38:28")
@StaticMetamodel(MyPetReport.class)
public class MyPetReport_ { 

    public static volatile SingularAttribute<MyPetReport, MyAppointments> appointments;
    public static volatile SingularAttribute<MyPetReport, String> diagnosis;
    public static volatile SingularAttribute<MyPetReport, Long> id;
    public static volatile SingularAttribute<MyPetReport, String> prognosis;

}