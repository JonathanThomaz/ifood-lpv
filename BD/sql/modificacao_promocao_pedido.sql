USE ifood;

ALTER TABLE produto 
			ADD COLUMN valor_desconto DECIMAL(2) NULL DEFAULT 0  
				AFTER disponivel;
                
  ALTER TABLE pedido 
			ADD COLUMN estadoPedido VARCHAR(50) NOT NULL DEFAULT 'Aguardando aprovacao' AFTER valorTotal,
            DROP COLUMN sePediuEntrega,
			DROP COLUMN idEstadoPedido,
			DROP COLUMN estadoPagamento;

DROP TABLE estadopedido;