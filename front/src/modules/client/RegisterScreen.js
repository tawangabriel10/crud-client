import React from 'react';
import { connect } from 'react-redux';
import { findByCep } from '../../store/actions/cep';
import { Button, ButtonToolbar, Row } from 'react-bootstrap';
import { Col, Label, Input } from 'reactstrap';
import { AvField, AvForm } from 'availity-reactstrap-validation';
import AvGroup from 'availity-reactstrap-validation/lib/AvGroup';
import { save } from '../../store/actions/cliente';

class RegisterScreen extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            name: '',
            cpf: '',
            emails: [],
            address: {},
            cep: '',
            desAddress: this.props.dataAddress ? this.props.dataAddress.address : '',
            number: '',
            complement: '',
            burgh: this.props.dataAddress ? this.props.dataAddress.burgh : '',
            city: this.props.dataAddress ? this.props.dataAddress.city : '',
            uf: this.props.dataAddress ? this.props.dataAddress.uf : ''
        }
    }

    findDataCep = () => {
        console.log('INFO CEP: ', this.state.cep)
        this.props.findByCep(this.state.cep);
    }

    handleSubmitForm = (event, errors, values) => {
        if (errors.length === 0) {
            this.setState({ address: {
                cep: values.cep,
                address: values.desAddress,
                number: values.number,
                complement: values.complement,
                burgh: values.burgh,
                city: values.city,
                uf: values.uf
            }});
            this.props.save(this.state, this.props.history);
        }
    }

    onCancelar = () => {
        this.props.history.goBack();
    }

    handleChange = (evt) => {
        if (evt && evt.target) {
            this.setState({ [evt.target.name]: evt.target.value });
        }
    }

    render() {
        return(
            <div className="container" id="content">
                <h1>Cadastrar Cliente</h1>
                <div className="boxer">
                    <AvForm onSubmit={this.handleSubmitForm} style={{ marginTop: 20 }}>
                    
                        <AvGroup>
                            <Row>
                                <Col sm="4" md="2">
                                    <Label className="col-form-label">Nome<span className="obrigatorio"> *</span></Label>
                                </Col>
                                <Col xs="12" sm="8" md="10">
                                    <AvField
                                        type="text"
                                        name="name"                                  
                                        grid={{ xs: 12, sm: 12 }}
                                        value={this.state.name}
                                        onChange={this.handleChange}
                                        validate={{
                                        required: { value: true, errorMessage: 'Nome é de preenchimento obrigatório' }
                                        }} >
                                    </AvField>
                                </Col>
                            </Row>
                        </AvGroup>
                        
                        <AvGroup>
                            <Row>
                                <Col sm="4" md="2">
                                    <Label className="col-form-label">CPF<span className="obrigatorio"> *</span></Label>
                                </Col>
                                <Col xs="12" sm="8" md="10">
                                    <AvField
                                        type="number"
                                        name="cpf"                                       
                                        grid={{ xs: 12, sm: 12 }}
                                        value={this.state.cpf}
                                        onChange={this.handleChange}
                                        validate={{
                                        required: { value: true, errorMessage: 'CPF é de preenchimento obrigatório' }
                                        }} >
                                    </AvField>
                                </Col>
                            </Row>
                        </AvGroup>

                        <AvGroup>
                            <Row>
                                <Col sm="4" md="2">
                                    <Label className="col-form-label">CEP<span className="obrigatorio"> *</span></Label>
                                </Col>
                                <Col xs="12" sm="8" md="10">
                                    <AvField
                                        type="number"
                                        name="cep"                                       
                                        grid={{ xs: 12, sm: 12 }}
                                        value={this.state.cep}
                                        onChange={this.handleChange}
                                        validate={{
                                        required: { value: true, errorMessage: 'CEP é de preenchimento obrigatório' }
                                        }} >
                                    </AvField>
                                </Col>
                                <Button onClick={() => this.findDataCep()} color="dark">
                                    Consultar
                                </Button>
                            </Row>
                        </AvGroup>  

                        <AvGroup>
                            <Row>
                                <Col sm="4" md="2">
                                    <Label className="col-form-label">Logradouro<span className="obrigatorio"> *</span></Label>
                                </Col>
                                <Col xs="12" sm="8" md="10">
                                    <AvField
                                        type="text"
                                        name="desAddress"                                       
                                        grid={{ xs: 12, sm: 12 }}
                                        value={this.state.desAddress}
                                        onChange={this.handleChange}
                                        validate={{
                                        required: { value: true, errorMessage: 'CPF é de preenchimento obrigatório' }
                                        }} >
                                    </AvField>
                                </Col>
                            </Row>
                        </AvGroup>  

                        <AvGroup>
                            <Row>
                                <Col sm="4" md="2">
                                    <Label className="col-form-label">Bairro<span className="obrigatorio"> *</span></Label>
                                </Col>
                                <Col xs="12" sm="8" md="10">
                                    <AvField
                                        type="text"
                                        name="burgh"                                       
                                        grid={{ xs: 12, sm: 12 }}
                                        value={this.state.burgh}
                                        onChange={this.handleChange}
                                        validate={{
                                        required: { value: true, errorMessage: 'CPF é de preenchimento obrigatório' }
                                        }} >
                                    </AvField>
                                </Col>
                            </Row>
                        </AvGroup>  

                        <AvGroup>
                            <Row>
                                <Col sm="4" md="2">
                                    <Label className="col-form-label">Cidade<span className="obrigatorio"> *</span></Label>
                                </Col>
                                <Col xs="12" sm="8" md="10">
                                    <AvField
                                        type="text"
                                        name="city"                                       
                                        grid={{ xs: 12, sm: 12 }}
                                        value={this.state.city}
                                        onChange={this.handleChange}
                                        validate={{
                                        required: { value: true, errorMessage: 'Cidade é de preenchimento obrigatório' }
                                        }} >
                                    </AvField>
                                </Col>
                            </Row>
                        </AvGroup>  

                        <AvGroup>
                            <Row>
                                <Col sm="4" md="2">
                                    <Label className="col-form-label">UF<span className="obrigatorio"> *</span></Label>
                                </Col>
                                <Col xs="12" sm="8" md="10">
                                    <AvField
                                        type="text"
                                        name="uf"                                       
                                        grid={{ xs: 12, sm: 12 }}
                                        value={this.state.uf}
                                        onChange={this.handleChange}
                                        validate={{
                                        required: { value: true, errorMessage: 'UF é de preenchimento obrigatório' }
                                        }} >
                                    </AvField>
                                </Col>
                            </Row>
                        </AvGroup>  

                        <AvGroup>
                            <Row>
                                <Col sm="4" md="2">
                                    <Label className="col-form-label">Complemento</Label>
                                </Col>
                                <Col xs="12" sm="8" md="10">
                                    <AvField
                                        type="text"
                                        name="complement"                                       
                                        grid={{ xs: 12, sm: 12 }}
                                        value={this.state.complement}
                                        onChange={this.handleChange} >
                                    </AvField>
                                </Col>
                            </Row>
                        </AvGroup>  

                        <AvGroup>
                            <Row>
                                <Col sm="4" md="2">
                                    <Label className="col-form-label">Numero</Label>
                                </Col>
                                <Col xs="12" sm="8" md="10">
                                    <AvField
                                        type="number"
                                        name="number"                                       
                                        grid={{ xs: 12, sm: 12 }}
                                        value={this.state.number}
                                        onChange={this.handleChange}>
                                    </AvField>
                                </Col>
                            </Row>
                        </AvGroup>  
            
                        <hr style={{ marginTop: 50 }}/>     
                        <div className="toolbar" style={{ marginTop: 15 }}>
                            <ButtonToolbar>
                                <Button type="submit" color="dark">
                                    Salvar
                                </Button>
                                <Button onClick={() => this.onCancelar()} color="dark">
                                    Cancelar
                                </Button>
                            </ButtonToolbar>
                        </div>
                    </AvForm>
                </div>                
            </div>
        );
    }
}

const mapStateToProps = (state) => {
    return {
        dataAddress: state.cep.dataAddress
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        findByCep: (cep) => dispatch(findByCep(cep)),
        save: (client, history) => dispatch(save(client, history))
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(RegisterScreen);