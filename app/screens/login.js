import React from "react";
import {
  View,
  Image,
  TextInput,
  StyleSheet,
  KeyboardAvoidingView,
  TouchableOpacity
} from "react-native";
import { Button, Text } from 'native-base';

export default class Login extends React.Component {
  render() {
    return (
      <View style={styles.wrapper}>

        <Text>Login into Aries </Text>

        <KeyboardAvoidingView behavior="padding" style={styles.loginContainer}>
          
          <TextInput
            placeholder="School email"
            placeholderTextColor='whitesmoke'
            style={styles.input}
          />

          <TextInput
            placeholder="password"
            secureTextEntry
            placeholderTextColor='whitesmoke'
            style={styles.input}
          />

          <Button primary><Text> Login </Text></Button>

          <Button style={styles.loginbutton} onPress={() => this.props.navigation.navigate("Grades")}>
            Hello World
          </Button>

          <TouchableOpacity  >
            <Text style={{
              textAlign: 'center',
              color: "whitesmoke",
              fontWeight: '700',
            }}>
              Login
            </Text>
          </TouchableOpacity>

        </KeyboardAvoidingView>

      </View>
    );
  }
}



const styles = ({
  loginContainer: {
    
    backgroundColor: "blue"
  },

  input: {
    paddingHorizontal: 10,
    marginBottom: 10,
    color: 'blue',
    backgroundColor: 'grey',
  },

  logo: {
    width: 231,
    height: 231
  },

  loginbutton: {
    marginRight: 40,
    marginLeft: 40,
    marginTop: 10,
    paddingTop: 3,
    paddingBottom: 3,
  },

  wrapper: {
    flex: 1,
    backgroundColor: 'white',
    alignItems: "center",
    justifyContent: "center"
  }

});