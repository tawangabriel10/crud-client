import React from 'react';
import { connect } from 'react-redux';
import { AvField, AvForm } from 'availity-reactstrap-validation';
import { ButtonToolbar, Button } from 'react-bootstrap';
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
        if (errors.length === 0 && !this.state.loading) {
            const user = { username: values.username, password: values.password };
            console.log('USER', user);
            this.props.login(user, this.props.history);
        }
    }

    render() {
        return (
            <div className="container" id="content">

                <AvForm onSubmit={this.handleSubmitForm}>
                    <AvField name="username"
                        label="Username"
                        type="text"
                        grid={{ xs: 12, sm: 10 }}
                        onChange={this.handerValue}
                        value={this.state.username}
                        validate={{
                            required: { value: true, errorMessage: 'Campo Usuário de preenchimento obrigatório' }
                        }}
                    />

                    <AvField name="password"
                        label="Password"
                        type="password"
                        grid={{ xs: 12, sm: 10 }}
                        onChange={this.handlerValue}
                        value={this.state.password}
                        validate={{
                            required: { value: true, errorMessage: 'Campo Senha de preenchimento obrigatório' }
                        }}

                    />
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