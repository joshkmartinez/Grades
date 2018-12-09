import React from "react";
import {
  View,
  //KeyboardAvoidingView,
  Dimensions,
  //AsyncStorage,
  //ActivityIndicator,
  SafeAreaView,
  FlatList
} from "react-native";
//import { Button, Text, Toast, Root, Container } from "native-base";
import { _ } from "lodash";
import { List } from "react-native-elements";
import {
  BottomNavigation,
  Surface,
  Button,
  //List,
  Headline,
  Switch,
  Divider,
  Paragraph,
  Dialog,
  Portal,
  Appbar
} from "react-native-paper";
import { withNavigation } from "react-navigation";
import { Text, Toast, Root } from "native-base";
import { default as Student } from "../components/studentLoginForm";
import { default as Parent } from "../components/parentLoginForm";
import ScrollableTabView, {
  DefaultTabBar
} from "react-native-scrollable-tab-view";

let width = Dimensions.get("window").width;
let height = Dimensions.get("window").height;

export class classGrades extends React.Component {
  static navigationOptions = {
    title: "$ClassName"
  };

  constructor(props) {
    super(props);
    this.state = {
      data: [
        {
          name: "Vocabulary W/S",
          grade: 90,
          letterGrade: "A-",
          category: "Classwork",
          pointsEarned: 9,
          pointsOutOf: 10
        },
        {
          name: "Book 3 Exam",
          grade: 100,
          letterGrade: "A+",
          category: "Tests/Quizes",
          pointsEarned: 50,
          pointsOutOf: 50
        },
        {
          name: "Really Long Pop Quiz (Maybe with some of this)",
          grade: 95,
          letterGrade: "A",
          category: "Classwork",
          pointsEarned: 19,
          pointsOutOf: 20
        }
      ],
      loading: false
    };
  }
  componentDidMount() {
    {
      /*make sure user has internet*/
    }
  }
  refresh() {
    //get grades and repopulate tabs
    //refresh

    this.setState({ isAuthed: true });
  }

  componentWillMount() {}
  makeRemoteRequest = () => {
    /*
    const { page, seed } = this.state;
    const url = `https://randomuser.me/api/?seed=${seed}&page=${page}&results=20`;
    this.setState({ loading: true });
  
    fetch(url)
      .then(res => res.json())
      .then(res => {
        this.setState({
          data: page === 1 ? res.results : [...this.state.data, ...res.results],
          error: res.error || null,
          loading: false,
          refreshing: false
        });
      })
      .catch(error => {
        this.setState({ error, loading: false });
      });*/
    //do request stuff

    this.setState({ loading: true });

    fetch("https://randomuser.me/api/?seed=33&page=3&results=567")
      .then(res => res.json())
      .then(res => {
        this.setState({
          loading: false
        });
      })
      .catch(error => {
        this.setState({ error, loading: false });
      });
  };

  handleRefresh = () => {
    this.setState({ loading: true });
    this.makeRemoteRequest();
  };

  renderSeparator = () => {
    return (
      <View>
        {/*<View
        style={{
          height: 1,
          width: "86%",
          backgroundColor: "#CED0CE",
          marginLeft: "14%"
        }}
      />*/}
      </View>
    );
  };

  renderHeader = () => {
    return <View />;
  };
  classSelected = className => {
    //open a page with the grades showing
  };
  renderFooter = () => {
    if (!this.state.loading) return null;

    return (
      <View
        style={{
          paddingVertical: 20,
          borderTopWidth: 1
        }}
      >
        {/*<ActivityIndicator animating size="large" />*/}
      </View>
    );
  };
  render() {
    return (
      <Root
        styles={{ flex: 1, alignItems: "center", justifyContent: "center" }}
      >
        <SafeAreaView
          style={{ flex: 1, alignItems: "center", justifyContent: "center" }}
        >
          <List
            containerStyle={{
              borderTopWidth: 0,
              borderBottomWidth: 0,
              marginTop: 6,
              flex: 1,
              backgroundColor: "transparent"
            }}
          >
            <FlatList
              //style={{ width: width }}
              data={this.state.data}
              renderItem={({ item, index }) => (
                <Surface
                  style={{
                    margin: 3,
                    padding: 6,
                    backgroundColor: "grey",
                    //elevation: 3,
                    justifyContent: "center",
                    width: width - 16,

                    height: 60
                  }}
                >
                  <View
                    style={{
                      alignItems: "center",
                      flexDirection: "row",
                      flex: 1
                    }}
                  >
                    <View
                        style={{
                          //backgroundColor: "blue",
                          //height: 20,
                          width: width - width / 2 - 21,
                          //justifyContent: "center",
                          //alignItems: "center",
                          //flexDirection: "row"
                        }}
                      >
                      <Text
                        ///adjustsFontSizeToFit
                        numberOfLines={1}
                        style={{
                          textAlign: "left",
                          alignSelf: "stretch",
                          color: "white",
                          fontSize: responsiveFontSize(1.89)
                        }}
                      >
                        {item.name}
                      </Text>
                      <Text
                        numberOfLines={1}
                        style={{
                          textAlign: "left",
                          alignSelf: "stretch",
                          color: "white",
                          fontSize: responsiveFontSize(1.5)
                        }}
                      >
                        {item.category}
                      </Text>
                    </View>
                    <View
                        style={{
                          //backgroundColor: "red",
                          //height: 20,
                          width: width - width / 2 - 20,
                          flexDirection: "column",
                          justifyContent: "center"
                        }}
                      >
                      <Text
                        style={{
                          textAlign: "right",
                          //alignSelf: "stretch",
                          color: "white",
                          fontSize: responsiveFontSize(1.7)
                        }}
                      >
                        {item.pointsEarned + "/" + item.pointsOutOf}
                      </Text>
                      <Text
                        style={{
                          textAlign: "right",
                          //alignSelf: "stretch",
                          color: "white",
                          fontSize: responsiveFontSize(1.55)
                        }}
                      >
                        {item.letterGrade}
                      </Text>
                    </View>
                  </View>
                </Surface>
              )}
              ItemSeparatorComponent={this.renderSeparator}
              ListHeaderComponent={this.renderHeader}
              ListFooterComponent={this.renderFooter}
              keyExtractor={item => item.name}
              onRefresh={this.handleRefresh}
              refreshing={this.state.loading}
            />
          </List>
        </SafeAreaView>
      </Root>
    );
  }
}

const styles = {};
const responsiveFontSize = f => {
  return Math.sqrt(height * height + width * width) * (f / 100);
};
export default withNavigation(classGrades);
