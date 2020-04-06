package sample;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Generuje potrzebne do symulacji nazwy filmow, maila, daty, a takze imiona i nazwiska aktorow i kraje.
 */

public class Generator implements Serializable{
    //tablica 100 najlpopularniejszych slow w jezyku angielskim zrodlo: https://gist.github.com/gravitymonkey/2406023
    String[] slowa = new String[]{"the","of","and","a","to","in","is","you","that","it","he","was","for","on","are","as","with","his","they","I","at","be","this","have","from","or","one","had","by","word","but","not","what","all","were","we","when","your","can","said","there","use","an","each","which","she","do","how","their","if","will","up","other","about","out","many","then","them","these","so","some","her","would","make","like","him","into","time","has","look","two","more","write","go","see","number","no","way","could","people","my","than","first","water","been","call","who","oil","its","now","find","long","down","day","did","get","come","made","may","part"};;
    //tablica krajow zrodlo: https://gist.github.com/whitehawks/3b507d7005448eebb9c9e78ce853c254
    String[] kraje = new String[]{"Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegowina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory", "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo", "Congo, the Democratic Republic of the", "Cook Islands", "Costa Rica", "Cote d'Ivoire", "Croatia (Hrvatska)", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", "Finland", "France", "France Metropolitan", "French Guiana", "French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Heard and Mc Donald Islands", "Holy See (Vatican City State)", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran (Islamic Republic of)", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea, Democratic People's Republic of", "Korea, Republic of", "Kuwait", "Kyrgyzstan", "Lao, People's Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libyan Arab Jamahiriya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia, The Former Yugoslav Republic of", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia, Federated States of", "Moldova, Republic of", "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn", "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russian Federation", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Seychelles", "Sierra Leone", "Singapore", "Slovakia (Slovak Republic)", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Georgia and the South Sandwich Islands", "Spain", "Sri Lanka", "St. Helena", "St. Pierre and Miquelon", "Sudan", "Suriname", "Svalbard and Jan Mayen Islands", "Swaziland", "Sweden", "Switzerland", "Syrian Arab Republic", "Taiwan, Province of China", "Tajikistan", "Tanzania, United Republic of", "Thailand", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "United States Minor Outlying Islands", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Virgin Islands (British)", "Virgin Islands (U.S.)", "Wallis and Futuna Islands", "Western Sahara", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe"};
    String[] imiona = new String[]{"Christian", "Amy", "Jack", "Sam", "John", "Andrzej", "Dariusz", "Paul"};
    String[] nazwiska = new String[]{"Christensen", "Adams", "Meler", "Smith", "Kovalsky", "Nawrocki"};
    String nazwa;
    String email;
    Date data;

    public Generator(){
        this.nazwa = "";
        //do zmiany ten kontruktor, ale na razie trudno
        this.data = new Date(1998,7,3);
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }



    public String generuj_nazwe(int ile_slow){
        Random generator = new Random();
        this.nazwa = "";
        for(int i=0; i<ile_slow - 1; i++){
            this.nazwa = this.nazwa + slowa[generator.nextInt(99)] + " ";
        }
        this.nazwa = this.nazwa + slowa[generator.nextInt(99)];
        return this.nazwa;
    }

    public String generuj_login(int ile_slow){
        Random generator = new Random();
        this.nazwa = "";
        for(int i=0; i<ile_slow; i++){
            this.nazwa = this.nazwa + slowa[generator.nextInt(99)];
        }
        this.email = this.nazwa + "@mail.com";
        return this.nazwa;
    }

    public String generuj_nazwe_dystrybutora(int ile_slow){
        Random generator = new Random();
        this.nazwa = "";
        for(int i=0; i<ile_slow; i++){
            this.nazwa = this.nazwa + slowa[generator.nextInt(99)];
        }
        this.nazwa = this.nazwa + " Films";
        return this.nazwa;
    }

    public Date generuj_date() {
        Random generator = new Random();
        int rok;
        int miesiac;
        int dzien;
        rok = generator.nextInt(40) + 1970;
        miesiac = generator.nextInt(11) + 1;
        dzien = generator.nextInt(27) + 1; //Dla uproszzcenia nie losuje dni powyzej 27. Nie zmienia to szczegolnie losowosci symulacji, a upraszcza generowanie
        this.data.setYear(rok);
        this.data.setMonth(miesiac);
        this.data.setDate(dzien);
        return this.data;
    }

    public String generuj_kraj(){
        Random generator = new Random();
        this.nazwa = this. kraje[generator.nextInt(this.kraje.length)];
        return nazwa;
    }

    public String generuj_aktora(){
        Random generator = new Random();
        return this.nazwa = this.imiona[generator.nextInt(this.imiona.length)] + " " + this. nazwiska[generator.nextInt(this.nazwiska.length)];
    }
}
