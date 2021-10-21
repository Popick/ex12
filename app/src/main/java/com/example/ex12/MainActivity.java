package com.example.ex12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,AdapterView.OnItemClickListener{
    int spinPos = 0;
    String spn[] = {"Select class:","cyber","electronica","art","tikshoret"};

    student cyber[] = new student[12];
    student electronica[] = new student[12];
    student art[] = new student[12];
    student tikshoret[] = new student[12];
    student[][] classes = {cyber,electronica,art,tikshoret};

    String cyberNames[] = new String[12];
    String electronicaNames[] = new String[12];
    String artNames[] = new String[12];
    String tikshoretNames[] = new String[12];
    String[][] classesNames = {cyberNames,electronicaNames,artNames,tikshoretNames};

    Spinner spin;
    ListView lV;
    TextView lname,fname,dob,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createClasses();
        listOfNames();

        lname = (TextView) findViewById(R.id.lname);
        fname = (TextView) findViewById(R.id.fname);
        dob = (TextView) findViewById(R.id.dob);
        phone = (TextView) findViewById(R.id.phone);
        spin = (Spinner) findViewById(R.id.spinner);
        lV = (ListView) findViewById(R.id.listview);

        spin.setOnItemSelectedListener(this);
        lV.setOnItemClickListener(this);
        lV.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,spn);
        spin.setAdapter(adp);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        lname.setText("Last name:\n"+classes[spinPos][position].getLastName());
        fname.setText("First name:\n"+classes[spinPos][position].getFirstName());
        dob.setText("Date of birth:\n"+classes[spinPos][position].getDateOfBirth());
        phone.setText("Phone:\n"+classes[spinPos][position].getPhone());
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0){
            lV.setAdapter(null);
            spinPos=0;
            lname.setText("Last name:");
            fname.setText("First name:");
            dob.setText("Date of birth:");
            phone.setText("Phone:");
        }else{
            ArrayAdapter<String> kidAdp = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,classesNames[position-1]);
            lV.setAdapter(kidAdp);
            spinPos=position-1;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void listOfNames(){
        for (int i=0;i<cyber.length;i++){
            cyberNames[i]=cyber[i].getFirstName()+" "+cyber[i].getLastName();
        }for (int i=0;i<cyber.length;i++){
            electronicaNames[i]=electronica[i].getFirstName()+" "+electronica[i].getLastName();
        }for (int i=0;i<cyber.length;i++){
            artNames[i]=art[i].getFirstName()+" "+art[i].getLastName();
        }for (int i=0;i<cyber.length;i++){
            tikshoretNames[i]=tikshoret[i].getFirstName()+" "+tikshoret[i].getLastName();
        }
    }

    public void createClasses() {
        cyber[0] = new student("etay", "sabag", "08/02/2005", "0535698482");
        cyber[1] = new student("paz", "malul", "04/08/2005", "0563421828");
        cyber[2] = new student("agam", "toledano", "25/03/2005", "0555474554");
        cyber[3] = new student("yuval", "navon", "11/10/2005", "0512858034");
        cyber[4] = new student("harel", "navon", "11/10/2005", "0514523793");
        cyber[5] = new student("ilai", "shimoni", "28/06/2005", "0522482132");
        cyber[6] = new student("harel", "lebobich", "07/08/2005", "0514692461");
        cyber[7] = new student("noa", "shetrit", "01/09/2005", "0566514049");
        cyber[8] = new student("keren", "vaintrub", " 24/11/2005", "0550054825");
        cyber[9] = new student("yakir", "biton", " 14/08/2005", "0545679099");
        cyber[10] = new student("albert", "levi", " 30/08/2005", "0551295860");
        cyber[11] = new student("issac", "shitrit", " 12/12/2005", "0571006467");

        electronica[0] = new student("John","Davis","27/10/2005","0582829994");
        electronica[1] = new student("Gerda","Calhoun","1/6/2005","0582539773");
        electronica[2] = new student("Mark","Fields","8/11/2005","0573630529");
        electronica[3] = new student("Mayra","Jenkins","14/4/2005","0546894949");
        electronica[4] = new student("James","Anderson","12/4/2005","0565691026");
        electronica[5] = new student("Robert","Adams","9/9/2005","0597311778");
        electronica[6] = new student("Silvia","Engleman","4/4/2005","0594173485");
        electronica[7] = new student("Dan","Kelly","8/5/2005","0562566394");
        electronica[8] = new student("John","Quayle","7/11/2005","0584467724");
        electronica[9] = new student("Nelson","Christopher","10/3/2005","0594591875");
        electronica[10] = new student("Irene","Ferreira","6/7/2005","0541626164");
        electronica[11] = new student("Margaret","Ferguson","9/1/2005","0520221037");

        art[0] = new student("Matthew","Stevenson","7/11/2005","0589857394");
        art[1] = new student("Randall","Yeiser","15/2/2005","0543533450");
        art[2] = new student("Elvis","Taylor","6/10/2005","0519269457");
        art[3] = new student("Sharon","Parrish","12/3/2005","0583883656");
        art[4] = new student("Alison","Nelson","1/2/2005","0546180275");
        art[5] = new student("Earl","Tracy","1/8/2005","0520626885");
        art[6] = new student("Ann","Lamp","9/8/2005","0513946444");
        art[7] = new student("Mark","Archer","12/5/2005","0522251405");
        art[8] = new student("Helen","Stassinos","24/3/2005","0548858366");
        art[9] = new student("Helen","Allen","17/9/2005","0571320498");
        art[10] = new student("Kurt","Thompson","21/5/2005","0593978134");
        art[11] = new student("Michael","Holder","18/4/2005","0517899251");

        tikshoret[0] = new student("Luther","Coleman","27/2/2005","0591986950");
        tikshoret[1] = new student("Lydia","Mccasland","9/10/2005","0567506535");
        tikshoret[2] = new student("Laurie","Downey","8/9/2005","0551193342");
        tikshoret[3] = new student("Steven","Jacobs","17/3/2005","0510801655");
        tikshoret[4] = new student("Katherine","Callahan","25/5/2005","0583248189");
        tikshoret[5] = new student("Daniella","Konty","18/11/2005","0530270443");
        tikshoret[6] = new student("Louie","Langdale","23/3/2005","0517994233");
        tikshoret[7] = new student("Rosemary","Thompson","17/8/2005","0550594130");
        tikshoret[8] = new student("Gary","Maciasz","22/9/2005","0525036539");
        tikshoret[9] = new student("Eulalia","Tilghman","27/5/2005","0532763231");
        tikshoret[10] = new student("Sally","Rung","17/11/2005","0531180659");
        tikshoret[11] = new student("Charles","Ruiz","24/4/2005","0563146551");
    }


}