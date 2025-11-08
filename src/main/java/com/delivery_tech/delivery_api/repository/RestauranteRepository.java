package com.delivery_tech.delivery_api.repository;

import java.math.BigDecimal;
import java.util.List;

import com.delivery_tech.delivery_api.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

    List<Restaurante> findByCategoria(String categoria);
    List<Restaurante> findByAtivoTrue();
    List<Restaurante> findByAvaliacaoGreaterThanEqual(BigDecimal avaliacao);
    List<Restaurante> findByTaxaEntregaLessThanEqual(BigDecimal taxa);

    @Query("SELECT r.nome as nomeReastaurante, " +
           "SUM(p.valorTotal) as totalVendas, " +
           "COUNT(p.id) as quantidadePedidos " +
           "FROM Restaurante r " +
           "LEFT JOIN Pedido p ON r.id = p.restaurante.id " +
           "GROUP BY r.id, r.nome")
           List<RelatorioVendas> relatorioVendasPorRestaurante();
           List<Restaurante> findByAtivoFalse();
           List<Restaurante> findByCategoriaAndAtivo(String categoria, Boolean ativo);

}
