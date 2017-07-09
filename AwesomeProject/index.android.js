/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import PropTypes from 'prop-types';
import React, { Component } from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  Button,
  NativeModules,
  requireNativeComponent
} from 'react-native';
module.exports = NativeModules.TestToastAndroid;
const TestModuleOne = NativeModules.TestToastAndroid

 var iface = {
	 name: 'ProgressBar',
	 propTypes: {
		 ...View.propTypes // include the default view properties
	},
};

var ProgressBar = requireNativeComponent('ProgressBar', iface);

export default class AwesomeProject extends Component {
	
	showToast(){
		TestModuleOne.show('Awesome Test !!!');
    }
	
    showToastTwo(){
		TestModuleOne.showTwo();
    }
	
	async callPromise(){
		console.log("first here ");
		try {
		var {
		  relativeX,
		  relativeY,
		  width,
		  height,
		} = await TestModuleOne.measureLayout(100, 100);

		console.log(relativeX + ':' + relativeY + ':' + width + ':' + height);
	  } catch (e) {
		console.error(e);
	  }
  }

  render() {
    return (
      <View style={styles.container}>
	    <ProgressBar />
        <Text style={styles.welcome}>
          Welcome to React Native!
        </Text>
        <Text style={styles.instructions}>
          To get started, edit index.android.js
        </Text>
        <Text style={styles.instructions}>
          Double tap R on your keyboard to reload,{'\n'}
          Shake or press menu button for dev menu
        </Text>
	    <Button title="Toast" onPress={this.showToast}/>
		<Button title="Toast Two" onPress={this.showToastTwo}/>
		<Button title="Promise" onPress={this.callPromise}/>
		<Button title="Call Activity :-)" onPress={() => NativeModules.ActivityStarter.navigateToExample()}/>
      </View>
	  
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});

AppRegistry.registerComponent('AwesomeProject', () => AwesomeProject);
