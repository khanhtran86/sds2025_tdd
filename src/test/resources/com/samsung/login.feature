Feature: Login with username and password function

  Scenario: Login without username and password
    Given The login page should be showed in user screen
    When  The user leave all field are blank then click Login
    Then The message "Vui lòng nhập dữ liệu" will be showed below username and password

  Scenario: Login with username and wrong password
    Given The login page should be showed in user screen
    When The user attempt to sign in with "khanh.tx@live.com" and password "abc123456"
    Then The message "Có lỗi xảy ra:\n- Mật khẩu không đúng, vui lòng kiểm tra lại" will be showed

  Scenario: Login with username and right password
    Given The login page should be showed in user screen
    When The user attempt to sign in with "khanh.tx@live.com" and password "@2KhanhTran"
    Then The Dashboard page will be showed
