package com.uss.facturacion.almacen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uss.facturacion.almacen.entity.Pago;
import java.util.List;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer>{
	public Pago findByDocumentoInquilino(String documentoInquilino);
	public List<Pago> findByDocumentoInquilinoContaining (String documentoInquilino);	
}
