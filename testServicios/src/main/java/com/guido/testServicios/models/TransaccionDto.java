package com.guido.testServicios.models;

public class TransaccionDto {
    private Long cuentaOringenId;
    private Long cuentaDestinoId;
    private Long monto;

    public Long getCuentaOringenId() {
        return cuentaOringenId;
    }

    public void setCuentaOringenId(Long cuentaOringenId) {
        this.cuentaOringenId = cuentaOringenId;
    }

    public Long getCuentaDestinoId() {
        return cuentaDestinoId;
    }

    public void setCuentaDestinoId(Long cuentaDestomoId) {
        this.cuentaDestinoId = cuentaDestomoId;
    }

    public Long getMonto() {
        return monto;
    }

    public void setMonto(Long monto) {
        this.monto = monto;
    }
}
