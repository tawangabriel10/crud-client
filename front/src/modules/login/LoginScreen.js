import React from 'react';
import { connect } from 'react-redux';
import { Col, Label, Input } from 'reactstrap';
import { AvField, AvForm } from 'availity-reactstrap-validation';
import AvGroup from 'availity-reactstrap-validation/lib/AvGroup';
import { ButtonToolbar, Button, Row } from 'react-bootstrap';
import { login } from '../../store/actions/authetication';

class LoginScreen extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            username: '',
            password: ''
        }
    }

    handleSubmitForm = (event, errors, values) => {
        if (errors.length === 0) {
            const user = { username: values.username, password: values.password };
            console.log('USER', user);
            this.props.login(user, this.props.history);
        }
    }

    render() {
        return (
            <div className="container" id="content">

                <AvForm onSubmit={this.handleSubmitForm}>
                        <h1>Login</h1>
                        <AvGroup>
                            <Row>
                                <Col sm="4" md="2">
                                    <Label className="col-form-label">Username<span className="obrigatorio"> *</span></Label>
                                </Col>
                                <Col xs="12" sm="8" md="10">
                                    <AvField
                                        type="text"
                                        name="username"                                  
                                        grid={{ xs: 12, sm: 12 }}
                                        value={this.state.username}
                                        onChange={this.handleChange}
                                        validate={{
                                        required: { value: true, errorMessage: 'Username é de preenchimento obrigatório' }
                                        }} >
                                    </AvField>
                                </Col>
                            </Row>
                        </AvGroup>
                        
                        <AvGroup>
                            <Row>
                                <Col sm="4" md="2">
                                    <Label className="col-form-label">Password<span className="obrigatorio"> *</span></Label>
                                </Col>
                                <Col xs="12" sm="8" md="10">
                                    <AvField
                                        type="password"
                                        name="password"                                       
                                        grid={{ xs: 12, sm: 12 }}
                                        value={this.state.password}
                                        onChange={this.handleChange}
                                        validate={{
                                        required: { value: true, errorMessage: 'Password é de preenchimento obrigatório' }
                                        }} >
                                    </AvField>
                                </Col>
                            </Row>
                        </AvGroup>           
                    <div className="toolbar" style={{ marginTop: 15 }}>
                        <ButtonToolbar>

                            <Button color="primary" type="submit" >
                                Logar
                                </Button>
                            <Button color="primary" >
                                Cancelar
                                </Button>

                        </ButtonToolbar>
                    </div>
                </AvForm>
            </div>
        );
    }
}


const mapStateToProps = (state) => {
    return {

    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        login: (user, history) => dispatch(login(user, history))
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(LoginScreen);