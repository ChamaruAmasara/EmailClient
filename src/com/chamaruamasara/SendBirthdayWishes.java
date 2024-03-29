package com.chamaruamasara;

import java.io.*;

import static com.chamaruamasara.ReturnCurrentDateAndTime.getCurrentDateTime;

public class SendBirthdayWishes {
    public SendBirthdayWishes() {


        //send birthday wishes


        // 08/07
        String newSpecificDateBirthDate = getCurrentDateTime().substring(5, 10).replace("-", "/");

        //load all data from file
        File file = new File("clientList.txt");


        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Declaring a string variable
        String recipientContent;
        int countBirthDays = 0;
        try {
            if (br != null) {
                while ((recipientContent = br.readLine()) != null)

                    // Print the string
                    if (recipientContent.contains(newSpecificDateBirthDate)) {
                        countBirthDays++;

                        String[] recipientType = recipientContent.split(":");
                        String[] recipientDetails = recipientType[1].split(",");
                        String birthdayHTMLEmailPart1 = """
                                <!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional //EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
                                <html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml" xmlns:o="urn:schemas-microsoft-com:office:office">
                                <head>
                                <!--[if gte mso 9]>
                                <xml>
                                  <o:OfficeDocumentSettings>
                                    <o:AllowPNG/>
                                    <o:PixelsPerInch>96</o:PixelsPerInch>
                                  </o:OfficeDocumentSettings>
                                </xml>
                                <![endif]-->
                                  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                                  <meta name="viewport" content="width=device-width, initial-scale=1.0">
                                  <meta name="x-apple-disable-message-reformatting">
                                  <!--[if !mso]><!--><meta http-equiv="X-UA-Compatible" content="IE=edge"><!--<![endif]-->
                                  <title></title>
                                  
                                    <style type="text/css">
                                      @media only screen and (min-width: 620px) {
                                  .u-row {
                                    width: 600px !important;
                                  }
                                  .u-row .u-col {
                                    vertical-align: top;
                                  }

                                  .u-row .u-col-100 {
                                    width: 600px !important;
                                  }

                                }

                                @media (max-width: 620px) {
                                  .u-row-container {
                                    max-width: 100% !important;
                                    padding-left: 0px !important;
                                    padding-right: 0px !important;
                                  }
                                  .u-row .u-col {
                                    min-width: 320px !important;
                                    max-width: 100% !important;
                                    display: block !important;
                                  }
                                  .u-row {
                                    width: calc(100% - 40px) !important;
                                  }
                                  .u-col {
                                    width: 100% !important;
                                  }
                                  .u-col > div {
                                    margin: 0 auto;
                                  }
                                }
                                body {
                                  margin: 0;
                                  padding: 0;
                                }

                                table,
                                tr,
                                td {
                                  vertical-align: top;
                                  border-collapse: collapse;
                                }

                                p {
                                  margin: 0;
                                }

                                .ie-container table,
                                .mso-container table {
                                  table-layout: fixed;
                                }

                                * {
                                  line-height: inherit;
                                }

                                a[x-apple-data-detectors='true'] {
                                  color: inherit !important;
                                  text-decoration: none !important;
                                }

                                table, td { color: #000000; } a { color: #0000ee; text-decoration: underline; } @media (max-width: 480px) { #u_row_1 .v-row-background-image--inner { background-position: center top !important; background-repeat: no-repeat !important; } #u_row_1 .v-row-background-image--outer { background-image: url('https://cdn.templates.unlayer.com/assets/1653987341859-mb.png') !important; background-position: center top !important; background-repeat: no-repeat !important; } #u_row_1.v-row-background-image--outer { background-image: url('https://cdn.templates.unlayer.com/assets/1653987341859-mb.png') !important; background-position: center top !important; background-repeat: no-repeat !important; } #u_row_1.v-row-padding--vertical { padding-top: 0px !important; padding-bottom: 31px !important; } #u_column_1 .v-col-padding { padding: 110px 0px 0px !important; } #u_content_image_1 .v-src-width { width: auto !important; } #u_content_image_1 .v-src-max-width { max-width: 65% !important; } #u_content_text_1 .v-container-padding-padding { padding: 40px 40px 10px !important; } #u_content_social_1 .v-container-padding-padding { padding: 40px 10px 10px !important; } #u_content_divider_1 .v-container-padding-padding { padding: 10px 50px !important; } }
                                    </style>
                                  
                                  

                                <!--[if !mso]><!--><link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css"><!--<![endif]-->

                                </head>

                                <body class="clean-body u_body" style="margin: 0;padding: 0;-webkit-text-size-adjust: 100%;background-color: #e7e7e7;color: #000000">
                                  <!--[if IE]><div class="ie-container"><![endif]-->
                                  <!--[if mso]><div class="mso-container"><![endif]-->
                                  <table style="border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;min-width: 320px;Margin: 0 auto;background-color: #e7e7e7;width:100%" cellpadding="0" cellspacing="0">
                                  <tbody>
                                  <tr style="vertical-align: top">
                                    <td style="word-break: break-word;border-collapse: collapse !important;vertical-align: top">
                                    <!--[if (mso)|(IE)]><table width="100%" cellpadding="0" cellspacing="0" border="0"><tr><td align="center" style="background-color: #e7e7e7;"><![endif]-->
                                    

                                <div id="u_row_1" class="u-row-container v-row-padding--vertical v-row-background-image--outer" style="padding: 0px;background-image: url('https://cdn.templates.unlayer.com/assets/1653986844783-bg.png');background-repeat: no-repeat;background-position: center top;background-color: transparent">
                                  <div class="u-row" style="Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;">
                                    <div class="v-row-background-image--inner" style="border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;">
                                      <!--[if (mso)|(IE)]><table width="100%" cellpadding="0" cellspacing="0" border="0"><tr><td class="v-row-background-image--outer" style="padding: 0px;background-image: url('https://cdn.templates.unlayer.com/assets/1653986844783-bg.png');background-repeat: no-repeat;background-position: center top;background-color: transparent;" align="center"><table cellpadding="0" cellspacing="0" border="0" style="width:600px;"><tr class="v-row-background-image--inner" style="background-color: transparent;"><![endif]-->
                                      
                                <!--[if (mso)|(IE)]><td align="center" width="600" class="v-col-padding" style="width: 600px;padding: 182px 0px 66px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;" valign="top"><![endif]-->
                                <div id="u_column_1" class="u-col u-col-100" style="max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;">
                                  <div style="height: 100%;width: 100% !important;">
                                  <!--[if (!mso)&(!IE)]><!--><div class="v-col-padding" style="padding: 182px 0px 66px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;"><!--<![endif]-->
                                  
                                <table style="font-family:arial,helvetica,sans-serif;" role="presentation" cellpadding="0" cellspacing="0" width="100%" border="0">
                                  <tbody>
                                    <tr>
                                      <td class="v-container-padding-padding" style="overflow-wrap:break-word;word-break:break-word;padding:10px 10px 1px;font-family:arial,helvetica,sans-serif;" align="left">
                                        
                                  <h3 style="margin: 0px; color: #344a84; line-height: 140%; text-align: center; word-wrap: break-word; font-weight: normal; font-family: 'Montserrat',sans-serif; font-size: 18px;">
                                    Today is the important date <br>of&nbsp;""";
                        String birthdayHTMLEmailPart2 = """
                                  </h3>

                                      </td>
                                    </tr>
                                  </tbody>
                                </table>

                                <table style="font-family:arial,helvetica,sans-serif;" role="presentation" cellpadding="0" cellspacing="0" width="100%" border="0">
                                  <tbody>
                                    <tr>
                                      <td class="v-container-padding-padding" style="overflow-wrap:break-word;word-break:break-word;padding:0px 10px;font-family:arial,helvetica,sans-serif;" align="left">
                                        
                                  <h1 style="margin: 0px; color: #344a84; line-height: 140%; text-align: center; word-wrap: break-word; font-weight: normal; font-family: 'Montserrat',sans-serif; font-size: 40px;">
                                    <strong>Happy Birthday</strong>
                                  </h1>

                                      </td>
                                    </tr>
                                  </tbody>
                                </table>

                                <table style="font-family:arial,helvetica,sans-serif;" role="presentation" cellpadding="0" cellspacing="0" width="100%" border="0">
                                  <tbody>
                                    <tr>
                                      <td class="v-container-padding-padding" style="overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:arial,helvetica,sans-serif;" align="left">
                                        
                                  <h1 style="margin: 0px; color: #344a84; line-height: 140%; text-align: center; word-wrap: break-word; font-weight: normal; font-family: 'Montserrat',sans-serif; font-size: 22px;">
                                    <strong>""";
                        String birthdayHTMLEmailPart3 = """
                                  !</strong>
                                  </h1>

                                      </td>
                                    </tr>
                                  </tbody>
                                </table>

                                <table id="u_content_image_1" style="font-family:arial,helvetica,sans-serif;" role="presentation" cellpadding="0" cellspacing="0" width="100%" border="0">
                                  <tbody>
                                    <tr>
                                      <td class="v-container-padding-padding" style="overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:arial,helvetica,sans-serif;" align="left">
                                        
                                <table width="100%" cellpadding="0" cellspacing="0" border="0">
                                  <tr>
                                    <td style="padding-right: 0px;padding-left: 0px;" align="center">
                                      
                                      <img align="center" border="0" src="https://cdn.templates.unlayer.com/assets/1653987052761-cake.png" alt="Birthday Cake" title="Birthday Cake" style="outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 46%;max-width: 266.8px;" width="266.8" class="v-src-width v-src-max-width"/>
                                      
                                    </td>
                                  </tr>
                                </table>

                                      </td>
                                    </tr>
                                  </tbody>
                                </table>

                                <table id="u_content_text_1" style="font-family:arial,helvetica,sans-serif;" role="presentation" cellpadding="0" cellspacing="0" width="100%" border="0">
                                  <tbody>
                                    <tr>
                                      <td class="v-container-padding-padding" style="overflow-wrap:break-word;word-break:break-word;padding:10px 55px;font-family:arial,helvetica,sans-serif;" align="left">
                                        
                                  <div style="line-height: 140%; text-align: left; word-wrap: break-word;">
                                    <p style="font-size: 14px; line-height: 140%; text-align: center;">""";
                        String birthdayHTMLEmailPart4 = """
                                  </p>
                                  </div>

                                      </td>
                                    </tr>
                                  </tbody>
                                </table>

                                <table style="font-family:arial,helvetica,sans-serif;" role="presentation" cellpadding="0" cellspacing="0" width="100%" border="0">
                                  <tbody>
                                    <tr>
                                      <td class="v-container-padding-padding" style="overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:arial,helvetica,sans-serif;" align="left">
                                        
                                  <h1 style="margin: 0px; color: #344a84; line-height: 140%; text-align: center; word-wrap: break-word; font-weight: normal; font-family: 'Montserrat',sans-serif; font-size: 22px;">
                                    <strong>Warm Wishes by Chamaru</strong>
                                  </h1>

                                      </td>
                                    </tr>
                                  </tbody>
                                </table>

                                <table id="u_content_social_1" style="font-family:arial,helvetica,sans-serif;" role="presentation" cellpadding="0" cellspacing="0" width="100%" border="0">
                                  <tbody>
                                    <tr>
                                      <td class="v-container-padding-padding" style="overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:arial,helvetica,sans-serif;" align="left">
                                        
                                <div align="center">
                                  <div style="display: table; max-width:258px;">
                                  <!--[if (mso)|(IE)]><table width="258" cellpadding="0" cellspacing="0" border="0"><tr><td style="border-collapse:collapse;" align="center"><table width="100%" cellpadding="0" cellspacing="0" border="0" style="border-collapse:collapse; mso-table-lspace: 0pt;mso-table-rspace: 0pt; width:258px;"><tr><![endif]-->
                                  
                                    
                                    <!--[if (mso)|(IE)]><td width="32" style="width:32px; padding-right: 5px;" valign="top"><![endif]-->
                                    <table align="left" border="0" cellspacing="0" cellpadding="0" width="32" height="32" style="width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 5px">
                                      <tbody><tr style="vertical-align: top"><td align="left" valign="middle" style="word-break: break-word;border-collapse: collapse !important;vertical-align: top">
                                        <a href="https://facebook.com/ChamaruAmasara" title="Facebook" target="_blank">
                                          <img src="https://cdn.tools.unlayer.com/social/icons/circle/facebook.png" alt="Facebook" title="Facebook" width="32" style="outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important">
                                        </a>
                                      </td></tr>
                                    </tbody></table>
                                    <!--[if (mso)|(IE)]></td><![endif]-->
                                    
                                    <!--[if (mso)|(IE)]><td width="32" style="width:32px; padding-right: 5px;" valign="top"><![endif]-->
                                    <table align="left" border="0" cellspacing="0" cellpadding="0" width="32" height="32" style="width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 5px">
                                      <tbody><tr style="vertical-align: top"><td align="left" valign="middle" style="word-break: break-word;border-collapse: collapse !important;vertical-align: top">
                                        <a href="https://www.linkedin.com/in/chamaru/" title="LinkedIn" target="_blank">
                                          <img src="https://cdn.tools.unlayer.com/social/icons/circle/linkedin.png" alt="LinkedIn" title="LinkedIn" width="32" style="outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important">
                                        </a>
                                      </td></tr>
                                    </tbody></table>
                                    <!--[if (mso)|(IE)]></td><![endif]-->
                                    
                                    <!--[if (mso)|(IE)]><td width="32" style="width:32px; padding-right: 5px;" valign="top"><![endif]-->
                                    <table align="left" border="0" cellspacing="0" cellpadding="0" width="32" height="32" style="width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 5px">
                                      <tbody><tr style="vertical-align: top"><td align="left" valign="middle" style="word-break: break-word;border-collapse: collapse !important;vertical-align: top">
                                        <a href="https://instagram.com/chamaru.me" title="Instagram" target="_blank">
                                          <img src="https://cdn.tools.unlayer.com/social/icons/circle/instagram.png" alt="Instagram" title="Instagram" width="32" style="outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important">
                                        </a>
                                      </td></tr>
                                    </tbody></table>
                                    <!--[if (mso)|(IE)]></td><![endif]-->
                                    
                                    <!--[if (mso)|(IE)]><td width="32" style="width:32px; padding-right: 5px;" valign="top"><![endif]-->
                                    <table align="left" border="0" cellspacing="0" cellpadding="0" width="32" height="32" style="width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 5px">
                                      <tbody><tr style="vertical-align: top"><td align="left" valign="middle" style="word-break: break-word;border-collapse: collapse !important;vertical-align: top">
                                        <a href="https://wa.me/+94718624816" title="WhatsApp" target="_blank">
                                          <img src="https://cdn.tools.unlayer.com/social/icons/circle/whatsapp.png" alt="WhatsApp" title="WhatsApp" width="32" style="outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important">
                                        </a>
                                      </td></tr>
                                    </tbody></table>
                                    <!--[if (mso)|(IE)]></td><![endif]-->
                                    
                                    <!--[if (mso)|(IE)]><td width="32" style="width:32px; padding-right: 5px;" valign="top"><![endif]-->
                                    <table align="left" border="0" cellspacing="0" cellpadding="0" width="32" height="32" style="width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 5px">
                                      <tbody><tr style="vertical-align: top"><td align="left" valign="middle" style="word-break: break-word;border-collapse: collapse !important;vertical-align: top">
                                        <a href="mailto:hello@chamaru.me" title="Email" target="_blank">
                                          <img src="https://cdn.tools.unlayer.com/social/icons/circle/email.png" alt="Email" title="Email" width="32" style="outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important">
                                        </a>
                                      </td></tr>
                                    </tbody></table>
                                    <!--[if (mso)|(IE)]></td><![endif]-->
                                    
                                    <!--[if (mso)|(IE)]><td width="32" style="width:32px; padding-right: 5px;" valign="top"><![endif]-->
                                    <table align="left" border="0" cellspacing="0" cellpadding="0" width="32" height="32" style="width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 5px">
                                      <tbody><tr style="vertical-align: top"><td align="left" valign="middle" style="word-break: break-word;border-collapse: collapse !important;vertical-align: top">
                                        <a href="https://m.me/ChamaruAmasara" title="Messenger" target="_blank">
                                          <img src="https://cdn.tools.unlayer.com/social/icons/circle/messenger.png" alt="Messenger" title="Messenger" width="32" style="outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important">
                                        </a>
                                      </td></tr>
                                    </tbody></table>
                                    <!--[if (mso)|(IE)]></td><![endif]-->
                                    
                                    <!--[if (mso)|(IE)]><td width="32" style="width:32px; padding-right: 0px;" valign="top"><![endif]-->
                                    <table align="left" border="0" cellspacing="0" cellpadding="0" width="32" height="32" style="width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 0px">
                                      <tbody><tr style="vertical-align: top"><td align="left" valign="middle" style="word-break: break-word;border-collapse: collapse !important;vertical-align: top">
                                        <a href="https://github.com/ChamaruAmasara" title="GitHub" target="_blank">
                                          <img src="https://cdn.tools.unlayer.com/social/icons/circle/github.png" alt="GitHub" title="GitHub" width="32" style="outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important">
                                        </a>
                                      </td></tr>
                                    </tbody></table>
                                    <!--[if (mso)|(IE)]></td><![endif]-->
                                    
                                    
                                    <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->
                                  </div>
                                </div>

                                      </td>
                                    </tr>
                                  </tbody>
                                </table>
                                            
                                                                      <table id="u_content_text_2" style="font-family:arial,helvetica,sans-serif;" role="presentation" cellpadding="0" cellspacing="0" width="100%" border="0">
                                                                                <tbody>
                                                                                    <tr>
                                                                                        <td class="v-container-padding-padding" style="overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:arial,helvetica,sans-serif;" align="left">
                                            
                                                                                            <div style="line-height: 140%; text-align: center; word-wrap: break-word;">
                                                                                                <p style="font-size: 14px; line-height: 140%;">   &nbsp;</p>
                                                                                            </div>
                                            
                                                                                        </td>
                                                                                    </tr>
                                                                                </tbody>
                                                                            </table>

                                <table id="u_content_divider_1" style="font-family:arial,helvetica,sans-serif;" role="presentation" cellpadding="0" cellspacing="0" width="100%" border="0">
                                  <tbody>
                                    <tr>
                                      <td class="v-container-padding-padding" style="overflow-wrap:break-word;word-break:break-word;padding:10px 80px;font-family:arial,helvetica,sans-serif;" align="left">
                                        
                                  <table height="0px" align="center" border="0" cellpadding="0" cellspacing="0" width="100%" style="border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;border-top: 1px solid #BBBBBB;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%">
                                    <tbody>
                                      <tr style="vertical-align: top">
                                        <td style="word-break: break-word;border-collapse: collapse !important;vertical-align: top;font-size: 0px;line-height: 0px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%">
                                          <span>&#160;</span>
                                        </td>
                                      </tr>
                                    </tbody>
                                  </table>

                                      </td>
                                    </tr>
                                  </tbody>
                                </table>

                                <table style="font-family:arial,helvetica,sans-serif;" role="presentation" cellpadding="0" cellspacing="0" width="100%" border="0">
                                  <tbody>
                                    <tr>
                                      <td class="v-container-padding-padding" style="overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:arial,helvetica,sans-serif;" align="left">
                                        
                                  <div style="line-height: 140%; text-align: center; word-wrap: break-word;">
                                    <p style="font-size: 14px; line-height: 140%;">© 2022 Chamaru Amasara All Rights Reserved</p>
                                  </div>

                                      </td>
                                    </tr>
                                  </tbody>
                                </table>

                                  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->
                                  </div>
                                </div>
                                <!--[if (mso)|(IE)]></td><![endif]-->
                                      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->
                                    </div>
                                  </div>
                                </div>


                                    <!--[if (mso)|(IE)]></td></tr></table><![endif]-->
                                    </td>
                                  </tr>
                                  </tbody>
                                  </table>
                                  <!--[if mso]></div><![endif]-->
                                  <!--[if IE]></div><![endif]-->
                                </body>

                                </html>
                                            """;

                        if (recipientType[0].toLowerCase().contains("office")) {
                            String recipientName = recipientDetails[0];
                            String recipientEmail = recipientDetails[1];
                            String recipientDesignation = recipientDetails[2];
                            System.out.println("""
                                    Recipient Details:
                                    \nName:\040""" + recipientName + """
                                    \nEmail:\040""" + recipientEmail + """
                                    \nDesignation:\040""" + recipientDesignation);


                            //send birthday email
                            Email officeFriendEmail = new Email(recipientEmail, "Happy Birthday 🥳!", birthdayHTMLEmailPart1 + recipientDesignation + birthdayHTMLEmailPart2 + recipientName + birthdayHTMLEmailPart3 + "Wish you a Happy Birthday!" + birthdayHTMLEmailPart4, getCurrentDateTime());

                            new SendMail(officeFriendEmail);
                            //serialize officeFriendEmail object

                        } else if (recipientType[0].toLowerCase().contains("personal")) {
                            String recipientName = recipientDetails[0];
                            String recipientNickName = recipientDetails[1];
                            String recipientEmail = recipientDetails[2];
                            System.out.println("""
                                    Recipient Details:\040
                                    \nName:\040""" + recipientName + """
                                    \nNickName:\040""" + recipientNickName + """
                                    \nEmail:\040""" + recipientEmail);


                            //send birthday email
                            Email personalFriendEmail = new Email(recipientEmail, "Happy Birthday " + recipientNickName + " ! 🥳", birthdayHTMLEmailPart1 + recipientNickName + birthdayHTMLEmailPart2 + recipientName + birthdayHTMLEmailPart3 + "Hugs and love on your birthday." + birthdayHTMLEmailPart4, getCurrentDateTime());

                            new SendMail(personalFriendEmail);

                        }

                    }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (countBirthDays == 1)
            System.out.println("There is 1 birthday today and sent 1 email.");
        else
            System.out.println("There are " + countBirthDays + " birthdays today and sent emails to all.");


    }

}
