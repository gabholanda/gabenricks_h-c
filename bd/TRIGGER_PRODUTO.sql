DELIMITER $$
CREATE TRIGGER ItensVendaInsert
 AFTER INSERT ON itempedido
 FOR EACH ROW
 BEGIN
 UPDATE produto SET qtdEstoque = qtdEstoque - NEW.qtdItem
 WHERE idproduto = NEW.idProduto;
 END$$
DELIMITER ;

