package br.com.crud.web.domain.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_client")
@Data
@NoArgsConstructor
public class Client implements Serializable {

}
