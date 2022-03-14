import React from 'react';

// import axios from 'axios';
// import Button from 'react-bootstrap/Button';


class CustomerPage extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
         
          custFirstname :'', 
          custLastname : '', 
          custEmail : '',
          
        };

        
    }

    componentDidMount(props){

        this.setState({
          custEmail: this.props.myPropEmail
        })
        this.setState({
          custFirstname: this.props.myPropFname
        })
        this.setState({
          custLastname: this.props.myPropLname
        })
      
    }
  

    render() {
      const { selectValue } = this.state;
     
      return (
      <React.Fragment>
        <h3>Hello, {this.props.custFirstname}&nbsp;{this.props.custLastname}</h3>
        <div class="col d-flex justify-content-center">
         <p> Hotel Bookings Main page</p>
        </div>

      </React.Fragment>);
    }
  }

export default CustomerPage;