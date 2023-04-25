package com.guido.testServicios;

import com.guido.testServicios.models.Cuenta;

import java.util.Optional;

public class Datos {


    public static final Optional<Cuenta> CUENTA_001 =Optional.of( new Cuenta(1l,"Guido",1000L));
    public static final Optional<Cuenta> CUENTA_002 =Optional.of( new Cuenta(2l,"Pepe",2000L));
    public static final Optional<Cuenta> CUENTA_003 =Optional.of( new Cuenta(3l,"Juan",3000L));
    public static final Optional<Cuenta> CUENTA_004 =Optional.of( new Cuenta(4l,"Maria",5000L));
    public static final Optional<Cuenta> CUENTA_005 =Optional.of( new Cuenta(5l,"Laura",10000L));
    public static final Optional<Cuenta> CUENTA_006 =Optional.of( new Cuenta(6l,"Romeo",200L));
    public static final Optional<Cuenta> CUENTA_007 =Optional.of( new Cuenta(7l,"Julieta",10L));

}
