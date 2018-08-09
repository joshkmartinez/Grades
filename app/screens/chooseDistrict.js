import React from "react";
import { View, FlatList, ActivityIndicator, Dimensions} from "react-native";
import { List, ListItem, SearchBar } from "react-native-elements";
import { getSchools } from "../api/index";
import { H1, H2, Text} from 'native-base';

let width = Dimensions.get("window").width;
let height = Dimensions.get("window").height;

export default class chooseDistrict extends React.Component {
  static navigationOptions = {
    title: "Choose School"
  };
  constructor(props) {
    super(props);

    this.state = {
      loading: false,
      data: [
        {
          CDS: "30736353030244",
          SchoolName: "Laguna Hills High",
          DistrictName: "Saddleback Valley Unified",
          Status: "active",
          County: "Orange",
          StreetAddress: "25401 Paseo de Valencia",
          City: "Laguna Hills",
          State: "CA",
          ZipCode: "92653",
          MailingAddress: "25401 Paseo de Valencia",
          MailingCity: "Laguna Hills",
          MailingState: "CA",
          MailingZipCode: "92653",
          AeriesAppParentURL: "https://familyportal.svusd.org/ParentPortal",
          AeriesAppStaffURL: "https://EM2.svusd.org/EM2",
          AeriesAppTeacherURL: "",
          AeriesAppParent: true,
          AeriesAppStaff: true,
          AeriesAppTeacher: false,
          RecordsTransferURL: "",
          RecordsTransfer: false,
          Fax: null,
          PublicPhone: "(949) 770-5447",
          PublicWebsite: "",
          OpenDate: "1980-07-01T00:00:00",
          CloseDate: "1900-01-01T00:00:00",
          isCharter: false,
          Latitude: "33.594318",
          Longitude: "-117.70108",
          PublicAdminFirstName: "Bill",
          PublicAdminLastName: "Hinds",
          PublicAdminEmail: "bill.hinds@svusd.org",
          HighGrade: 0,
          LowGrade: 0
        },
        {
          CDS: "49706074930327",
          SchoolName: "Laguna High",
          DistrictName: "West Sonoma County Union High",
          Status: "active",
          County: "Sonoma",
          StreetAddress: "445 Taft St.",
          City: "Sebastopol",
          State: "CA",
          ZipCode: "95472",
          MailingAddress: "445 Taft St.",
          MailingCity: "Sebastopol",
          MailingState: "CA",
          MailingZipCode: "95472",
          AeriesAppParentURL: "https://portal.wscuhsd.k12.ca.us/parentportal",
          AeriesAppStaffURL: "",
          AeriesAppTeacherURL: "",
          AeriesAppParent: true,
          AeriesAppStaff: false,
          AeriesAppTeacher: false,
          RecordsTransferURL: "",
          RecordsTransfer: false,
          Fax: null,
          PublicPhone: "(707) 824-6484",
          PublicWebsite: "",
          OpenDate: "1980-07-01T00:00:00",
          CloseDate: "1900-01-01T00:00:00",
          isCharter: false,
          Latitude: "38.406153",
          Longitude: "-122.82398",
          PublicAdminFirstName: "Kent",
          PublicAdminLastName: "Cromwell",
          PublicAdminEmail: "kcromwell.lhs@wscuhsd.k12.ca.us",
          HighGrade: 0,
          LowGrade: 0
        }
      ],
      error: null,
      query: ""
    };
  }
  componentDidMount() {
    this.makeRemoteRequest();
  }

  makeRemoteRequest = () => {
    this.setState({ loading: true });

    getSchools()
      .then(users => {
        this.setState({
          loading: false,
          data: schools
        });
      })
      .catch(error => {
        this.setState({ error, loading: false });
      });
  };
  handleSearch = text => {
    this.setState({ query: text });
  };

  renderSeparator = () => {
    return (
      <View
        style={{
          height: 2,
          backgroundColor: "whitesmoke",
        }}
      />
    );
  };

  renderHeader = () => {
    return <SearchBar
    lightTheme
    placeholder="Search for your school / district" 
    style={{width: width, backgroundColor: "white"}}
    />
  };

  renderFooter = () => {
    if (!this.state.loading) return null;

    return (
      <View
        style={{
          paddingVertical: 9,
          borderTopWidth: 1,
          borderColor: "whitesmoke"
        }}
      >
        <ActivityIndicator animating size="large" />
      </View>
    );
  };
  render() {
    return (
      <View style={{ flex: 1, alignItems: "center", justifyContent: "center", width: width }}>
        <List containerStyle={{ borderTopWidth: 0, borderBottomWidth: 0 }}>
          <FlatList
            data={this.state.data}
            renderItem={({ item }) => (
              <View>
              <H1>
                {item.SchoolName}
              </H1>
              <Text>
              {item.DistrictName}
              </Text>
              </View>
            )}
            keyExtractor={item => item.SchoolName}
            ItemSeparatorComponent={this.renderSeparator}
            ListHeaderComponent={this.renderHeader}
            ListFooterComponent={this.renderFooter}
          />
        </List>
      </View>
    );
  }
}
