class Lenkeliste<T> implements Liste<T> {
  //Jeg ser for meg lenkelisten som en slange, da er hode starten
  //og halen slutten
  Node hode;
  int antallElementer;
  class Node{
    Node neste;
    T data;
    public Node(T data){
      this.data=data;
    }
  }

  public void leggTil(T x){
    //Legger inn et element på slutten av listen
    antallElementer++;
    Node hjelpepeker=hode;
    if(hode==null){
      hode=new Node(x);
      return;
      }
    if(hode.neste==null){
      hode.neste=new Node(x);
      return;
    }
    while(hjelpepeker.neste!=null){
      hjelpepeker=hjelpepeker.neste;
    }
    hjelpepeker.neste=new Node(x);
  }

  public T fjern(){
    //fjerner hodet, og returnerer dataen i det nodeobjektet
    //Setter neste element i listen som det nye hodet
    if(hode==null){
      throw new UgyldigListeIndeks(0);
    }
    if(hode.neste==null){
      T skalReturneres=hode.data;
      hode=null;
      return skalReturneres;
    }
    T skalReturneres=hode.data;
    hode=hode.neste;
    return skalReturneres;
  }

  public void sett(int pos, T x){
    //Setter inn et nytt nodeobjekt i den gitte posisjonen
    //fjerner det elementet som var i den posisjonen tidligere
    Node hjelpepeker=hode;
    int teller=1;
    Node nyttElement=new Node(x);
    int stoerrelse=stoerrelse();
    //Sjekker noen ugyldige inputs
    if(pos<0){
      throw new UgyldigListeIndeks(pos);
    }
    if(pos>(stoerrelse-1)){
      throw new UgyldigListeIndeks(pos);
      }
    if(hode==null){
      throw new UgyldigListeIndeks(0);
    }
    if(pos==0){
      if(hode==null){
        throw new UgyldigListeIndeks(0);
        }
      if(hode!=null){
        nyttElement.neste=hode.neste;
        hode=nyttElement;
      }
    }
    if(pos==1){
      if(hode.neste==null){
        return;
        }
      if(hode.neste!=null){
        nyttElement.neste=hode.neste.neste;
        hode.neste=nyttElement;
        return;
      }
    }
    if(pos>1){
      while(teller<pos){
        hjelpepeker=hjelpepeker.neste;
        teller++;
      }
      if(hjelpepeker==null){
        throw new UgyldigListeIndeks(pos);
      }
      nyttElement.neste=hjelpepeker.neste.neste;
      hjelpepeker.neste=nyttElement;
      return;
    }

  }

  public void leggTil(int pos, T x){
    //Legger inn et nytt element i lenkelisten
    //forskyver følgende elementer en plass
    Node hjelpepeker=hode;
    int teller=1;
    Node nyttElement=new Node(x);
    int stoerrelse=stoerrelse();
    if(pos<0){
      throw new UgyldigListeIndeks(pos);
      }
      if(pos>stoerrelse){
        throw new UgyldigListeIndeks(pos);
        }
    if(hode==null&&pos!=0){
      throw new UgyldigListeIndeks(pos);
      }
    if(pos==0){
      if(hode==null){
        hode=nyttElement;
        return;
        }
      if(hode!=null){
        nyttElement.neste=hode;
        hode=nyttElement;
        return;
        }
      }
    if(pos==1){
      if(hode.neste==null){
        hode.neste=nyttElement;
        return;
        }
      if(hode.neste!=null){
        nyttElement.neste=hode.neste;
        hode.neste=nyttElement;
        return;
        }
      }
    while(teller<pos){
      hjelpepeker=hjelpepeker.neste;
      teller++;
      }
      nyttElement.neste=hjelpepeker.neste;
      hjelpepeker.neste=nyttElement;


    }

  public T fjern(int pos){
    //Fjerner et element fra listen og returnerer
    //dataen i det elementet
    Node hjelpepeker=hode;
    int teller=1;
    T skalReturneres;
    int stoerrelse=stoerrelse();
    //sjekker noen ugyldige input
    if(pos<0){
      throw new UgyldigListeIndeks(pos);
      }
    //er denne nødvengig?
    if(pos==0&&hode==null){
        throw new UgyldigListeIndeks(pos);
        }
    if(pos>(stoerrelse-1)){
      throw new UgyldigListeIndeks(pos);
      }
    if(pos==0){
      skalReturneres=hode.data;
      hode=hode.neste;
      return skalReturneres;
      }


    else if(pos>0){
      while(teller<pos){
        hjelpepeker=hjelpepeker.neste;
        teller++;
        }
      }
      skalReturneres=hjelpepeker.neste.data;
      hjelpepeker.neste=hjelpepeker.neste.neste;
      return skalReturneres;
    }

  public int stoerrelse(){
    //returnerer antall objekter i listen
    Node hjelpepeker=hode;
    int verdi=1;
    if(hode==null){
      return 0;
      }
    if(hode!=null&&hode.neste==null){
      return 1;
    }
    while(hjelpepeker.neste!=null){
      hjelpepeker=hjelpepeker.neste;
      verdi++;
      }
    return verdi;
  }

  public T hent(int pos){
    Node hjelpepeker=hode;
    int teller=0;
    int stoerrelse=stoerrelse();
    if(pos<0){
      throw new UgyldigListeIndeks(pos);
      }
      if(pos>(stoerrelse-1)){
        throw new UgyldigListeIndeks(pos);
        }

    if(pos==0){
      return hode.data;
      }

    while(teller<pos){
      hjelpepeker=hjelpepeker.neste;
      teller++;
      }
    return hjelpepeker.data;
    }

  public void reset(){
    Node hjelpepeker=hode;
    while(hjelpepeker.neste!=null){
      hjelpepeker.data=null;
      hjelpepeker=hjelpepeker.neste;
    }
    hode=null;
    antallElementer=0;
  }

}
