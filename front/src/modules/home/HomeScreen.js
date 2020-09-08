import React from 'react';
import { connect } from 'react-redux';
import { Button, ButtonToolbar, Table } from 'react-bootstrap';

class HomeScreen extends React.Component {

    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div className="container" id="content">
                <h1>Home</h1>

                <div className="table-responsive" style={{ marginTop: 10 }}>                 
    
                <Table responsive aria-describedby="deposito-heading">
                  <thead>
                    <tr>                  
                      <th className="align-text-top" style={{textAlign: 'center'}}>
                        ID 
                      </th>
                      <th className="align-text-top" style={{textAlign: 'center'}}>
                        Nome 
                      </th>     
                      <th className="align-text-top" style={{textAlign: 'center'}}>
                        CPF
                      </th>         
                      <th className="align-text-top" style={{textAlign: 'center'}}>
                        CEP
                      </th>
                    </tr>
                  </thead>
                  <tbody>

                    {
                      this.props.clients.map((cliente, i) => (
                        <tr key={i}>  
           
                            <td>{cliente.id}</td>
                
                            <td>{cliente.name}</td>
                
                            <td>{cliente.cpf}</td>

                            <td>{cliente.address.cep}</td>
                        
                        </tr>
                      ))}
                  </tbody> 
                </Table>            
              </div>

              <hr style={{ marginTop: 50 }}/>     
                  <div className="toolbar" style={{ marginTop: 15 }}>
                    <ButtonToolbar>            
                      <Button onClick={() => this.props.history.push('/register')} variant="dark">
                        Cadastrar
                      </Button>
                      <Button onClick={() => this.props.history.goBack()} variant="dark">
                        Voltar
                      </Button> 
                    </ButtonToolbar>
                  </div>
            </div>
        );
    }
}

const mapStateToProps = (state) => {
    return {
        clients: state.client.clients
    }
}

export default connect(mapStateToProps, null)(HomeScreen);