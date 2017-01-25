<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Новини</title>
</head>
<body>
<div class="wrapper">
    <div class="content">
        <div data-name="header" class="header">
            <div class="header-content">
                <div data-name="menu-top" class="menu-top">
                    <div class="nav"><a href="#dashboard" class="item logo active" data-name="menu-item" data-id="main"
                                        tabindex="1" title="Приват24"> <span class="icon"></span> </a> <a
                            href="#statements/cards/" class="item statements" data-name="menu-item" data-id="statements"
                            tabindex="2" title="Мої рахунки"> <span class="icon"></span> Мої рахунки </a> <a
                            href="#menu-app" class="item menu" data-name="menu-item" data-id="menu" tabindex="3"
                            data-step="3" title="Усі послуги"> <span class="icon"></span> Усі послуги </a> <a
                            href="#my-payments" class="item payments" data-name="menu-item" data-id="payments"
                            tabindex="4" title="Мої платежі"> <span class="icon"></span> Мої платежі </a> <a
                            href="#deposit/my" class="item deposits" data-name="menu-item" data-id="deposits"
                            tabindex="4" title="Депозити"> <span class="icon"></span> Депозити </a> <a href="#train"
                                                                                                       class="item tickets"
                                                                                                       data-name="menu-item"
                                                                                                       data-id="tickets"
                                                                                                       title="Квитки"
                                                                                                       tabindex="5">
                        <span class="icon"></span> </a> <a href="#investments/info" class="item investments hidden"
                                                           data-name="menu-item" data-id="investments" tabindex="7"
                                                           title="Інвест"> <span class="icon"></span> Інвест </a> <a
                            href="#archive-menu-app" class="item history" data-name="menu-item" data-id="history"
                            tabindex="6" data-step="7" title="Архів"> <span class="icon"></span> </a> <a
                            href="#support/faq" class="item support" data-name="menu-item" data-id="support"
                            tabindex="8" title="Підтримка"> <span class="icon"></span> </a> <a href="#cart/operations/"
                                                                                               class="item cart"
                                                                                               data-name="menu-item"
                                                                                               data-id="cart"
                                                                                               tabindex="9"
                                                                                               title="Кошик платежів">
                        <span class="icon"></span> <span class="cart-container" data-name="cart-container"><div
                            class="cart-brief empty">  </div> </span> </a></div>
                    <div class="clear"></div>
                </div>
                <div data-name="personal-info" class="personal-info">
                    <!--a class="icon settings" href="#" data-name="personal-settings-button" title="Налаштування"></a-->
                    <a class="icon exit" data-name="exitButton"
                       href="leave?xref=2a19c2b087a5a9223cd262a9eeb870b6705e52bc&amp;_=06414194389880159"
                       title="Вихід"></a> <a href="#change-personal/form"><img class="photo"
                                                                               src="./userPhoto/p24photo/author_with_soul.png"
                                                                               alt="" title="Мої налаштування"></a>
                    <input id="userfno" type="hidden" value="+380677581750"> <input id="userid" type="hidden"
                                                                                    value="9831543">
                    <div class="settings-block"><a class="item" href="#change-personal/form"> Профіль </a> <a
                            class="item"
                            href="leave?xref=2a19c2b087a5a9223cd262a9eeb870b6705e52bc&amp;_=06414194389880159"
                            title="Завершення сесії"> Вийти </a></div>
                </div>
                <div class="clear"></div>
            </div>
        </div>
        <div class="welcome_box" id="session_only">
            <div class="wellcome_user">
                <div data-name="exchange-rates-block" class="exchange-rates-block">
                    <div title="Курси валют на&nbsp;18.01.2017 19:54">
                        <div class="exchange-rates-block-section">
                            <div class="exchange-rates-block-section-content type"> BTC-ДОЛ:</div>
                            <div class="exchange-rates-block-section-content"> 828.290&nbsp;/&nbsp;915.478</div>
                        </div>
                        <div class="exchange-rates-block-section">
                            <div class="exchange-rates-block-section-content type"> ДОЛ:</div>
                            <div class="exchange-rates-block-section-content"> 27.500&nbsp;/&nbsp;28.902</div>
                        </div>
                        <div class="exchange-rates-block-section">
                            <div class="exchange-rates-block-section-content type"> ЄВРО:</div>
                            <div class="exchange-rates-block-section-content"> 29.30&nbsp;/&nbsp;30.96</div>
                        </div>
                        <div class="exchange-rates-block-section">
                            <div class="exchange-rates-block-section-content type"> РУБ:</div>
                            <div class="exchange-rates-block-section-content"> 0.4500&nbsp;/&nbsp;0.4900</div>
                        </div>
                    </div>
                </div>
                <div data-name="legal-person-switch" class="legal-person-block"></div>
            </div>
            <div data-name="session-container" class="session_counter_container" style="display: none;">Сесія
                закінчиться через <span data-name="counter">17:15</span></div>
            <div class="passPhrase" id="passPhrase"></div>
            <div data-name="info-for-user" class="info-for-user" style="display: none;">
                <div class="close-icon" data-name="close">Х</div>
                <div class="description">
                    <div class="side-left"><img src="img/infoForUser/protection.png" width="100"></div>
                    <div class="side-right"><p>Шановний клієнт, Ви увійшли в Приват24 без підтвердження на Ваш
                        фінансовий телефон.</p>
                        <p>Чому так сталося? Ми проаналізували велику кількість факторів, які гарантують той факт, що
                            даний сеанс є досить захищеним і в свій Приват24 зайшли саме Ви. Так буде відбуватися
                            завжди, коли рівень захищеності буде досить високим.</p>
                        <p>Якщо Ви захочете використовувати підтвердження входу в усіх випадках, Ви можете в будь-який
                            момент змінити це в кабінеті управління комунікаціями (Всі послуги - Налаштування - <a
                                    href="#sms-info/form">Управління комунікаціями</a>).</p></div>
                </div>
            </div>
            <div class="clear"></div>
        </div>
        <div class="top-container">
            <div class="menu-search-input-block" data-name="menu-search-input-block">
                <div data-name="search-container" class="search-container"><input class="input-field"
                                                                                  name="menu-search-field" value=""
                                                                                  type="text" x-webkit-speech=""
                                                                                  speech="" autocomplete="off"
                                                                                  autofocus="" data-step="1"
                                                                                  placeholder="Пошук" lang="uk"
                                                                                  data-intro="Скористайтеся пошуком для швидкого переходу в будь-який розділ Приват24">
                    <div class="search-autocomplete-block" data-name="search-autocomplete-block"
                         style="display: none;"></div>
                </div>
            </div>
            <div class="clear"></div>
        </div>
        <div class="main-container">
            <div data-name="data-container" class="data_container">
                <div class="money-transfer-widget-accounts-list-block"
                     data-name="money-transfer-accounts-list-block"></div>
                <div class="dashboard">
                    <div data-name="crm-container" class="dashboard-crm" style="display: block;">
                        <div id="p48_adv_incut" style="display: none;">
                            <script src="https://crm.privatbank.ua/pic/scripts/IncutPrivat24.js"
                                    type="text/javascript"></script>
                            <script type="text/javascript">
                                function crmClose(itemBlock) {
                                    document.getElementById(itemBlock).style.display = 'none';
                                }
                            </script>
                            <input type="hidden" value="AD" name="crm_decline" id="crm_decline"><input type="hidden"
                                                                                                       value="CO"
                                                                                                       name="crm_accept"
                                                                                                       id="crm_accept"></input><input
                                type="hidden" value="RE" name="crm_later" id="crm_later"><input type="hidden" value="AS"
                                                                                                name="crm_show"
                                                                                                id="crm_show"><input
                                type="hidden" id="crm_sid" name="crm_sid" value=""><input type="hidden" id="crm_ref"
                                                                                          name="crm_ref"
                                                                                          value="161222BM33236658"><input
                                type="hidden" id="crm_channel" name="crm_channel" value="P24">
                            <div class="product_20110630" id="crm_product" style="display: none;">
                                <div id="header"></div>
                                <div id="wrapper">
                                    <div id="for_image">
                                        <img alt="" id="crm_image" data-editable="crm_image"
                                             src="https://crm.privatbank.ua/pic/042787_P24_PB_UA_crm_image.gif"></div>
                                    <div id="for_content">
                                        <div id="crm_desc">
                                            <h3 id="appealCustomer_1" data-editable="appealCustomer_1">Євгене
                                                Михайловичу!</h3>
                                            <div class="text" data-editable="custom-14049993560490">
                                                <p data-editable="textClient1" id="textClient1"
                                                   xmlns="http://www.w3.org/1999/xhtml">Дякуємо Вам за те, що Ви є
                                                    власником картки класу Gold та учасником GOLD-клубу!<br>
                                                    <br>
                                                    З метою покращення якості Вашого обслуговування просимо відповісти
                                                    на запитання.<br>
                                                    <strong>Чи знаєте Ви контактний номер телефону Вашого персонального
                                                        банкіра&nbsp;в GOLD-клубі</strong>?</p>
                                            </div>
                                        </div>
                                        <div id="buttons" data-editable="buttons">
                                            <a href="#"
                                               onclick="send(['crm_sid', 'crm_ref', 'crm_channel'], 'crm_accept', [[]], [['crm_product'], ['crm_product_success', '60000'], ['crm_product_fail', '7000']]);"
                                               type="button" id="crm_no" data-editable="crm_order">Ні, не знаю</a><a
                                                class="btn_20110630"
                                                onclick="send(['crm_sid', 'crm_ref', 'crm_channel'], 'crm_decline', [[]], [['crm_product'], ['crm_product_decline', '1'],['crm_product_fail', '7000']]);"
                                                id="crm_no" type="button" data-editable="crm_no" href="#">Так,
                                            знаю</a><a href="#"
                                                       onclick="send(['crm_sid', 'crm_ref', 'crm_channel'], 'crm_later', [[]], [['crm_product'], ['crm_product_decline', '1'], ['crm_product_fail', '7000']]);"
                                                       type="button" id="crm_later" data-editable="crm_later">Нагадати
                                            пiзнiше</a>
                                            <div style="clear:both;"></div>
                                        </div>
                                    </div>
                                    <div style="clear:both;"></div>
                                </div>
                            </div>
                            <div class="product_hidden_20110630" id="crm_product_success">
                                <div id="header"></div>
                                <div id="wrapper">
                                    <div id="for_image">
                                        <img alt="" id="crm_image" data-editable="crm_image" class="photo"
                                             src="https://vip-services.privatbank.ua/p24/getPhoto/readfoto.php?token=1c9ca6fbf3e28d30d444c5158f6c8b5c&amp;ldap=K3070294BAV">
                                    </div>
                                    <div id="for_content">
                                        <div id="crm_desc">
                                            <h3 id="appealCustomer_access" data-editable="appealCustomer_access">Євгене
                                                Михайловичу</h3>
                                            <div class="text" data-editable="custom-14049993560511">
                                                <p data-editable="textClient2" id="textClient2">
                                                    <strong>Ваш персональний банкір:</strong>&nbsp;Бойко Анастасія
                                                    Володимирівна</p>
                                            </div>
                                        </div>
                                        <div id="buttons" data-editable="buttons">
                                            <a href="#" onclick="crmClose('crm_product_success');" type="button"
                                               id="crm_order_1" data-editable="crm_order_1">Закрити</a>
                                            <div style="clear:both;"></div>
                                        </div>
                                    </div>
                                    <div style="clear:both;"></div>
                                </div>
                            </div>
                            <div class="product_hidden_20110630" id="crm_product_decline" style="display: block;">
                                <div id="header"></div>
                                <div id="wrapper">
                                    <div id="for_image">
                                        <img alt=""
                                             src="https://crm.privatbank.ua/pic/042787_P24_PB_UA_custom-14049993560512.png"
                                             data-editable="custom-14049993560512"></div>
                                    <div id="for_content">
                                        <div id="crm_desc" data-editable="custom-14049993560513">
                                            <h3 data-editable="appealCustomer_decline" id="appealCustomer_decline">
                                                Дякуємо за увагу!</h3>
                                        </div>
                                        <div id="buttons" data-editable="buttons">
                                            <a href="#" onclick="crmClose('crm_product_decline');" type="button"
                                               id="crm_order_2" data-editable="crm_order_2">Закрити</a>
                                            <div style="clear:both;"></div>
                                        </div>
                                    </div>
                                    <div style="clear:both;"></div>
                                </div>
                            </div>
                            <div class="product_hidden_20110630" id="crm_product_fail">
                                <div id="header"></div>
                                <div id="wrapper">
                                    <div id="for_image">
                                        <img alt=""
                                             src="https://crm.privatbank.ua/pic/042787_P24_PB_UA_custom-14049993560514.png"
                                             data-editable="custom-14049993560514"></div>
                                    <div id="for_content">
                                        <div id="crm_desc" data-editable="custom-14049993560515">
                                            <h3 data-editable="appealCustomer_fail" id="appealCustomer_fail">Ой!
                                                Здається, щось пішло не так.<br>На жаль, ми не зберегли Вашу
                                                відповідь.<br>Вибачте, зараз полагодимо :)<br>Але нам доведеться ще раз
                                                показати Вам це повідомлення.</h3>
                                        </div>
                                        <div id="buttons" data-editable="buttons">
                                            <a href="#" onclick="crmClose('crm_product_fail');" type="button"
                                               id="crm_order_3" data-editable="crm_order_3">Закрити</a>
                                            <div style="clear:both;"></div>
                                        </div>
                                    </div>
                                    <div style="clear:both;"></div>
                                </div>
                            </div>
                            <input type="hidden" value="0451ca95ccc67516a583524b1f376d9d5c9e614a" name="crm_key"
                                   id="crm_key">
                            <style>            .dashboard-crm .product_20110630 {
                                margin: 0 auto;
                                width: 782px;
                                height: auto;
                                font-family: Helvetica, Arial, serif;
                            }

                            .dashboard-crm #header {
                                width: 780px;
                                height: 28px;
                                background: #B0E782;
                                background: -moz-linear-gradient(top, #B7EE89 0%, #B0E782 100%);
                                background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #B7EE89), color-stop(100%, #B0E782));
                                background: -webkit-linear-gradient(top, #B7EE89 0%, #B0E782 100%);
                                background: -o-linear-gradient(top, #B7EE89 0%, #B0E782 100%);
                                background: -ms-linear-gradient(top, #B7EE89 0%, #B0E782 100%);
                                background: linear-gradient(top, #B7EE89 0%, #B0E782 100%);
                                filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#B7EE89', endColorstr='#B0E782', GradientType=0);
                                border: 1px solid #B0E782;
                                border-radius: 5px 5px 0px 0px;
                                -webkit-border-radius: 5px 5px 0 0;
                                -moz-border-radius: 5px 5px 0 0;
                                border-bottom: 1px solid #8DB968;
                            }

                            .dashboard-crm #header p {
                                color: #686C65;
                                margin: 6px 10px;
                                font-size: 12px;
                                font-weight: bold;
                            }

                            .dashboard-crm #for_image {
                                float: left;
                                width: auto;
                            }

                            .dashboard-crm #for_image img {
                                margin: 20px;
                            }

                            .dashboard-crm .photo {
                                max-width: 160px;
                                max-height: 180px;
                            }

                            .dashboard-crm #for_content {
                                float: left;
                                width: 510px
                            }

                            .dashboard-crm #wrapper {
                                width: 780px;
                                border: 1px solid #CFCFCF;
                                border-radius: 0px 0px 5px 5px;
                                -webkit-border-radius: 0 0 5px 5px;
                                -moz-border-radius: 0 0 5px 5px;
                                border-top: 0px;
                                background: #FAFAFA;
                                box-shadow: 0px 1px 2px #DCDCDC;
                                -webkit-box-shadow: 0px 1px 2px #DCDCDC;
                                -moz-box-shadow: 0px 1px 2px #DCDCDC;
                            }

                            .dashboard-crm #buttons {
                                margin-bottom: 20px;
                            }

                            .dashboard-crm #crm_desc {
                                margin: 20px 0px;
                                min-height: 140px;
                            }

                            .dashboard-crm #crm_desc p {
                                font-size: 14px;
                                margin: 7px 0 0 0;
                            }

                            .dashboard-crm #crm_desc h3 {
                                margin: 0px;
                                font-size: 22px;
                            }

                            .dashboard-crm #crm_order, .dashboard-crm #crm_order_1, .dashboard-crm #crm_order_2, .dashboard-crm #crm_order_3 {
                                border: none;
                                color: #FFF;
                                background: #64a433;
                                background: -moz-linear-gradient(top, #64a433 0%, #4a8f30 100%);
                                background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #64a433), color-stop(100%, #4a8f30));
                                background: -webkit-linear-gradient(top, #64a433 0%, #4a8f30 100%);
                                background: -o-linear-gradient(top, #64a433 0%, #4a8f30 100%);
                                background: -ms-linear-gradient(top, #64a433 0%, #4a8f30 100%);
                                background: linear-gradient(top, #64a433 0%, #4a8f30 100%);
                                filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#64a433', endColorstr='#4a8f30', GradientType=0);
                                border-bottom: 1px solid #3a7b23;
                            }

                            .dashboard-crm #crm_no {
                                color: #333333;
                                background: #f9f9f9;
                                background: -moz-linear-gradient(top, #f9f9f9 0%, #dedede 100%);
                                background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #f9f9f9), color-stop(100%, #dedede));
                                background: -webkit-linear-gradient(top, #f9f9f9 0%, #dedede 100%);
                                background: -o-linear-gradient(top, #f9f9f9 0%, #dedede 100%);
                                background: -ms-linear-gradient(top, #f9f9f9 0%, #dedede 100%);
                                background: linear-gradient(top, #f9f9f9 0%, #dedede 100%);
                                filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#f9f9f9', endColorstr='#dedede', GradientType=0);
                                border: 1px solid #878787;
                            }

                            .dashboard-crm #crm_no, .dashboard-crm #crm_order, .dashboard-crm #crm_order_1, .dashboard-crm #crm_order_2, .dashboard-crm #crm_order_3 {
                                font-size: 13px;
                                font-weight: bold;
                                -webkit-border-radius: 3px;
                                -moz-border-radius: 3px;
                                border-radius: 3px;
                                padding: 5px 16px 5px;
                                -moz-box-shadow: 0 2px 2px #acacac;
                                -webkit-box-shadow: 0 2px 2px #acacac;
                                box-shadow: 0 2px 2px #acacac;
                                cursor: pointer;
                                margin-right: 12px;
                                text-decoration: none;
                            }

                            .dashboard-crm .product_20110630 input {
                                margin-top: 7px;
                                border: 1px solid #CCCCCC;
                                border-radius: 4px;
                                padding: 5px 8px;
                                color: #999999;
                                font-size: 14px;
                                width: 375px;
                                box-shadow: inset 0px 2px 3px #E4E4E4;
                                -webkit-box-shadow: inset 0px 2px 3px #E4E4E4;
                                -moz-box-shadow: inset 0px 2px 3px #E4E4E4;
                            }

                            .dashboard-crm .product_hidden_20110630 {
                                margin: 0 auto;
                                width: 782px;
                                height: auto;
                                font-family: Helvetica, Arial, serif;
                                display: none;
                            }

                            .dashboard-crm #crm_later {
                                font-size: 14px;
                                color: #777777;
                            }</style>
                        </div>
                    </div>
                    <div data-name="dashboard-container">
                        <div class="dashboard-line">
                            <div class="statement dashboard-item odd-item" data-name="statement"><a
                                    href="#statements/cards/" class="dashboard-item-title"> <span> <span
                                    class="dashboard-item-icon"></span> ВИПИСКИ </span> </a>
                                <div class="dashboard-item-body" data-name="accounts-container">
                                    <div class="statements-account-line" data-name="statements-account-line"
                                         data-id="5168742024499463">
                                        <div class="statements-account-block " data-name="statements-account-block">
                                            <div class="balance  " title="Доступний баланс"> 12.73&nbsp;
                                                <small>ГРН</small>
                                            </div>
                                            <div class="name" title="Назва картки/рахунку"> Картка для виплат Голд</div>
                                            <div class="credit"> на 18.01.2017 19:52</div>
                                            <div class="number"> **9463</div>
                                            <div class="list-icon"></div>
                                        </div>
                                        <div class="statements-list-block" data-name="statements-list-block"></div>
                                    </div>
                                    <div class="statements-account-line" data-name="statements-account-line"
                                         data-id="5168742347014288">
                                        <div class="statements-account-block " data-name="statements-account-block">
                                            <div class="balance  " title="Доступний баланс"> -36.82&nbsp;
                                                <small>ГРН</small>
                                            </div>
                                            <div class="name" title="Назва картки/рахунку"> Картка Універсальна Голд
                                            </div>
                                            <div class="credit"> (<span title="Кредитний ліміт"> 0.00 </span> - <span
                                                    title="Кредитна заборгованість"> 36.82 </span>) на 18.01.2017 19:52
                                            </div>
                                            <div class="number"> **4288</div>
                                            <div class="list-icon"></div>
                                        </div>
                                        <div class="statements-list-block" data-name="statements-list-block"></div>
                                    </div>
                                    <div class="statements-account-line" data-name="statements-account-line"
                                         data-id="5363542306360737">
                                        <div class="statements-account-block " data-name="statements-account-block">
                                            <div class="balance  " title="Доступний баланс"> -36.82&nbsp;
                                                <small>ГРН</small>
                                            </div>
                                            <div class="name" title="Назва картки/рахунку"> Картка Універсальна Голд
                                            </div>
                                            <div class="credit"> (<span title="Кредитний ліміт"> 0.00 </span> - <span
                                                    title="Кредитна заборгованість"> 36.82 </span>) на 18.01.2017 19:52
                                            </div>
                                            <div class="number"> **0737</div>
                                            <div class="list-icon"></div>
                                        </div>
                                        <div class="statements-list-block" data-name="statements-list-block"></div>
                                    </div>
                                    <div class="statements-more-info"><a href="#" data-name="link-more-accounts"
                                                                         class="more-info-link"> Показати ще </a></div>
                                </div>
                            </div>
                            <div class="mobile dashboard-item" data-name="mobile"><a href="#mobile/form"
                                                                                     class="dashboard-item-title"
                                                                                     title="Поповнюйте будь-який номер телефону із 140 країн світу">
                                <div class="dashboard-item-icon"></div>
                                <div class="mobile-widget-name"><span>ПОПОВНИТИ</span> <br> зараз в 140 країнах</div>
                                <div class="mobile-widget-img-operators"></div>
                            </a>
                                <div class="dashboard-item-body">
                                    <div class="step-form mobile-widget">
                                        <div class="step">
                                            <div class="tabs"><a class="item active" name="refill-type" data-id="mobile"
                                                                 href="#">Мобільний</a> <a class="item "
                                                                                           name="refill-type"
                                                                                           data-id="viber" href="#">Viber</a>
                                                <a class="item" name="refill-type" data-id="skype" href="#">Skype</a> <a
                                                        class="item" name="refill-type" data-id="city"
                                                        href="#">Міський</a></div>
                                            <form action="/" method="post" data-name="form" class="mobile-widget-form">
                                                <div class="form-line last-payments" data-name="last-payments"></div>
                                                <div data-name="phone" class="form-line">
                                                    <div class="input"><input type="tel" class="middle" value="+380"
                                                                              maxlength="14" required="required"
                                                                              name="phone">
                                                        <div class="preloader mobile-widget-phone-preloader hidden"
                                                             data-name="phone-preloader"></div>
                                                    </div>
                                                </div>
                                                <div class="form-line hidden" data-name="operator"></div>
                                                <div class="form-line" data-name="amount">
                                                    <div class="input"><input type="tel" value="" class="small"
                                                                              placeholder="45" maxlength="5"
                                                                              required="required" name="amount"> <span
                                                            data-name="currency">ГРН</span></div>
                                                </div>
                                                <div data-name="card" class="form-line">
                                                    <div class="input"><select required="required" name="card"
                                                                               class="reading">
                                                        <option value="">Оберіть картку</option>
                                                        <option data-id="5168742024499463"
                                                                value="5168742024499463- 5168757231575384 "
                                                                ismulticurrency="false"> 12.73&nbsp;ГРН&nbsp; Картка для
                                                            виплат Голд&nbsp;**9463
                                                        </option>
                                                    </select></div>
                                                </div>
                                                <div data-name="account-of-other-bank" style="display: none;"></div>
                                                <div class="form-line buttons">
                                                    <button class="button" type="submit">Поповнити</button>
                                                    <a href="#mass-mobile-payments/form">Масове поповнення</a></div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="dashboard-line">
                            <div class="communal dashboard-item odd-item" data-name="communal"><a href="#my-payments"
                                                                                                  class="dashboard-item-title">
                                <span> <span class="dashboard-item-icon"></span> ОПЛАТИТИ </span> </a>
                                <div class="dashboard-item-body" data-name="communal-templates-container">
                                    <div data-name="communal-templates-list-block">
                                        <div class="communal-template-item" data-name="communal-template-item"
                                             data-id="template_id=192762655">
                                            <div class="communal-template-item-info-section">
                                                <div class="communal-template-item-icon "></div>
                                            </div>
                                            <div class="communal-template-item-info-section"
                                                 title="Проживание в общежитии"><span
                                                    class="communal-template-item-name info-line">Проживание в общежитии</span>
                                                <div class="communal-template-item-description info-line interlinear">
                                                    Национальный технический университет Украины "Киевский
                                                    политехнический институт"
                                                </div>
                                            </div>
                                            <div class="communal-template-item-info-section">
                                                <div class="communal-template-item-amount info-line  "></div>
                                            </div>
                                            <div class="clear"></div>
                                        </div>
                                        <div class="communal-template-item static"
                                             data-name="communal-template-static-item" data-id="new_26">
                                            <div class="communal-template-item-info-section">
                                                <div class="communal-template-item-icon gas"></div>
                                            </div>
                                            <div class="communal-template-item-info-section" title="Газ"><span
                                                    class="communal-template-item-name info-line">Газ</span></div>
                                            <div class="communal-template-item-info-section last"><a class="button"
                                                                                                     data-name="static-template-button"
                                                                                                     href="#my-payments">
                                                Ввести реквізити </a></div>
                                            <div class="clear"></div>
                                        </div>
                                        <div class="communal-template-item static"
                                             data-name="communal-template-static-item" data-id="new_28">
                                            <div class="communal-template-item-info-section">
                                                <div class="communal-template-item-icon electricity"></div>
                                            </div>
                                            <div class="communal-template-item-info-section" title="Электроэнергия">
                                                <span class="communal-template-item-name info-line">Электроэнергия</span>
                                            </div>
                                            <div class="communal-template-item-info-section last"><a class="button"
                                                                                                     data-name="static-template-button"
                                                                                                     href="#my-payments">
                                                Ввести реквізити </a></div>
                                            <div class="clear"></div>
                                        </div>
                                    </div>
                                    <div class="communal-info-block more-info"><a href="#my-payments"
                                                                                  class="more-info-link"
                                                                                  data-name="link-more-templates">
                                        Показати ще </a></div>
                                </div>
                            </div>
                            <div class="money-transfer dashboard-item" data-name="money-transfer">
                                <div class="dashboard-item-title">
                                    <div class="dashboard-item-icon"></div>
                                    ПЕРЕКАЗАТИ
                                </div>
                                <div class="dashboard-item-body">
                                    <form class="money-transfer-widget-form" data-name="form" action="/" method="post">
                                        <div class="tabs">
                                            <div class="item active" data-name="receiverType" data-id="account">На
                                                картку
                                            </div>
                                            <div class="item " data-name="receiverType" data-id="phone">За номером
                                                телефону
                                            </div>
                                            <div class="item " data-name="receiverType" data-id="email">E-mail</div>
                                        </div>
                                        <div class="form-line">
                                            <div class="label"><label for="money-transfer-payer-account">З
                                                картки/рахунку:</label></div>
                                            <div class="input"><select id="money-transfer-payer-account"
                                                                       name="payerAccount" class="reading">
                                                <option data-id="5168742024499463"
                                                        value="5168742024499463- 5168757231575384 "
                                                        ismulticurrency="false"> 12.73&nbsp;ГРН&nbsp; Картка для виплат
                                                    Голд&nbsp;**9463
                                                </option>
                                                <option data-id="26309608357495" value="26309608357495- 26309608357495 "
                                                        ismulticurrency="false"> 0.00&nbsp;ГРН&nbsp; Послуга
                                                    «Скарбничка»&nbsp;**7495
                                                </option>
                                            </select></div>
                                        </div>
                                        <div class="form-line">
                                            <div class="label visible-overflow"><label for="receiver-account-label"
                                                                                       class="receiver-type-label">
                                                Картка: </label></div>
                                            <div class="input visible-overflow"><input value="" name="receiverAccount"
                                                                                       type="tel" class="large">
                                                <div title="Мої рахунки" class="money-transfer-widget-accounts-button"
                                                     data-name="money-transfer-accounts-button"></div>
                                                <div class="hint">Номер картки одержувача</div>
                                            </div>
                                        </div>
                                        <div class="form-line">
                                            <div class="label"><label for="money-transfer-amount">Сума:</label></div>
                                            <div class="input"><input id="money-transfer-amount" class="small"
                                                                      type="tel" name="amount" value=""> <select
                                                    name="currency" class="small">
                                                <option value="UAH">ГРН</option>
                                                <option value="EUR">ЄВРО</option>
                                                <option value="USD">ДОЛ</option>
                                            </select> <span class="currencyCardRecipient"
                                                            id="currencyCardRecipient"></span></div>
                                        </div>
                                        <div class="form-line"><input class="button" value="Переказати"
                                                                      title="Переказати" type="submit"></div>
                                        <div class="clear"></div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="dashboard-line">
                            <div class="privat-market dashboard-item odd-item" data-name="privat-market">
                                <div class="dashboard-item-title"><a
                                        href="https://privatmarket.ua/retail?utm_source=p24&amp;utm_medium=widget&amp;utm_content=logo&amp;utm_campaign=privatmarket"
                                        target="_blank" class="dashboard-item-icon"></a> ПРИВАТМАРКЕТ <input
                                        placeholder="Що Ви бажаєте придбати?" type="text" data-name="search"
                                        class="search"></div>
                                <div class="dashboard-item-body">
                                    <div class="tabs">
                                        <div class="item" data-name="tabs-item" data-id="partPayment">Оплата частинами
                                        </div>
                                        <div class="item active" data-name="tabs-item" data-id="catalog">Каталог</div>
                                    </div>
                                    <div class="dashboard-item-body-content" data-name="content">
                                        <div class="catalog"><a class="catalog-item laptop"
                                                                href="https://privatmarket.ua/category/kompyutery-seti?utm_source=p24&amp;utm_medium=widget&amp;utm_content=catalog-kompyutery-seti&amp;utm_campaign=privatmarket"
                                                                target="_blank"> Комп'ютерна<br>техніка </a> <a
                                                class="catalog-item phones"
                                                href="https://privatmarket.ua/category/smartfony_telefony?utm_source=p24&amp;utm_medium=widget&amp;utm_content=catalog-smartfony_telefony&amp;utm_campaign=privatmarket"
                                                target="_blank"> Телефони </a> <a class="catalog-item equipment"
                                                                                  href="https://privatmarket.ua/category/bytovaya_tehnika?utm_source=p24&amp;utm_medium=widget&amp;utm_content=catalog-bytovaya_tehnika&amp;utm_campaign=privatmarket"
                                                                                  target="_blank"> Побутова <br> техніка
                                        </a> <a class="catalog-item electronic"
                                                href="https://privatmarket.ua/category/elektronika?utm_source=p24&amp;utm_medium=widget&amp;utm_content=catalog-elektronika&amp;utm_campaign=privatmarket"
                                                target="_blank"> Електроніка </a> <a class="catalog-item tire"
                                                                                     href="https://privatmarket.ua/category/avto_i_moto?utm_source=p24&amp;utm_medium=widget&amp;utm_content=catalog-avto_i_moto&amp;utm_campaign=privatmarket"
                                                                                     target="_blank"> Авто </a> <a
                                                class="catalog-item toys"
                                                href="https://privatmarket.ua/category/detskie_tovary?utm_source=p24&amp;utm_medium=widget&amp;utm_content=catalog-detskie_tovary&amp;utm_campaign=privatmarket"
                                                target="_blank"> Дитячі<br>товари </a> <a
                                                href="https://privatmarket.ua/retail?utm_source=p24&amp;utm_medium=widget&amp;utm_content=catalog-retail&amp;utm_campaign=privatmarket"
                                                class="more-button" target="_blank"> Відкрити каталог </a></div>
                                    </div>
                                </div>
                            </div>
                            <div class="charity dashboard-item odd-item" data-name="charity">
                                <div class="dashboard-item-title">
                                    <div class="dashboard-item-icon"></div>
                                    БЛАГОДІЙНІСТЬ
                                </div>
                                <div class="dashboard-item-body"><br>
                                    <form class="charity-payment-form" data-name="form" action="/" method="post"
                                          style="line-height: 18px;">
                                        <div class="clear"></div>
                                        <div class="form-line">
                                            <div class="label"><label for="charity-amount">Послуга*:</label></div>
                                            <div name="service" class="input" style="overflow:visible">
                                                <div data-name="service" cid="view603" style="display: none;"></div>
                                                <div class="search-select" data-select-list-name="search-select"
                                                     cid="view603" data-name="service" style="display: block;">
                                                    <div class="select"><span>Оберіть зі списку</span>
                                                        <div class="icon"></div>
                                                    </div>
                                                    <input type="text" class="tab-catcher">
                                                    <div class="options-container"
                                                         style="overflow-x: hidden; width: 322px; display: none;">
                                                        <div class="search-input"><input type="text">
                                                            <div>search</div>
                                                        </div>
                                                        <div class="options-list"
                                                             style="float: none; overflow-y: scroll; max-height: 76px; height: 76px;">
                                                            <a class="option " id="view603c599" data-cid="c599"> Заради
                                                                життя - допомога дітям, хворим на рак </a><a
                                                                class="option " id="view603c598" data-cid="c598">
                                                            Допомога дитячим будинкам України </a><a class="option "
                                                                                                     id="view603c601"
                                                                                                     data-cid="c601">
                                                            Допомога пораненим в АТО </a><a class="option "
                                                                                            id="view603c602"
                                                                                            data-cid="c602"> Підтримка
                                                            армії </a><a class="option " id="view603c600"
                                                                         data-cid="c600"> Таблеточки
                                                        </a></div>
                                                    </div>
                                                </div>
                                                <div><a class="hint" title="Детальніше про програму"
                                                        href="https://blago.privatbank.ua/"
                                                        target="_blank">докладніше</a></div>
                                            </div>
                                        </div>
                                        <div class="form-line " data-name="payerAccount">
                                            <div class="label"> З картки/рахунку&nbsp;*:</div>
                                            <div class="input"><select name="payerAccount" required="required"
                                                                       class="reading">
                                                <option value="">Оберіть картку</option>
                                                <option data-id="5168742024499463"
                                                        value="5168742024499463- 5168757231575384 "
                                                        ismulticurrency="false"> 12.73&nbsp;ГРН&nbsp; Картка для виплат
                                                    Голд&nbsp;**9463
                                                </option>
                                            </select></div>
                                        </div>
                                        <div class="form-line">
                                            <div class="label"><label for="charity-amount">Сума*:</label></div>
                                            <div class="input"><input id="money-transfer-amount" class="small"
                                                                      type="tel" name="amount" value=""> <span
                                                    name="currency" data-name="currency-label"></span></div>
                                        </div>
                                        <div class="form-line"><input class="button" value="Пожертвувати"
                                                                      title="Пожертвувати" type="submit"></div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<div data-name="footer-block" class="footer_box">
    <div class="footer_content">
        <div class="footer_menu"><a href="http://privatbank.ua/apps/" class="menu" target="_blank">Мобільна версія</a>
            <a href="http://privatbank.ua/pay/" class="menu" target="_blank">Регламент/Тарифи</a> <a
                    href="http://privatbank.ua/safeness/" class="menu" target="_blank">Правила безпеки</a> <a
                    href="https://api.privatbank.ua" class="menu" target="_blank">API</a> <a href="#support/mail/new"
                                                                                             class="menu"
                                                                                             target="_blank">Написати
                лист</a></div>
        <div class="info-footer-block">
            <div class="contact_phone">
                <div class="mobile_phone"></div>
                <div class="free-calls"><b>3700</b> <br>безкоштовні дзвінки з мобільних</div>
                <div class="ic_phone"></div>
                <div class="abroad-calls"><b>+380567161131</b> <br>для дзвінків з-за кордону</div>
                <div class="copyright"> © 2016 <a href="http://privatbank.ua/" target="_blank" class="copy_link">ПриватБанк</a>
                    <br>Ліцензія № 22 від 05.10.2011 р.
                </div>
                <div class="secure_box"></div>
            </div>
        </div>
    </div>
</div>


<div id="ads"></div>
<div class="sender-wrapper sender-wrapper-i68481723518 sender-hidden right-center" style="height: 634px; width: 400px;">
    <div class="sender-widget-drag"></div>
    <iframe class="sender-widget-frame" id="widget-frame-i68481723518" src="https://widget.sender.mobi/build/index.html"
            frameborder="0" scrolling="no" style="background-color: transparent;"></iframe>
    <div class="sender-widget-resize"
         style="background: url(&quot;https://widget.sender.mobi/build/images/resize.png&quot;) no-repeat;"></div>
</div>
<iframe id="sender-analytics" src="https://widget.sender.mobi/build/20161227212750/analytics.html"
        style="position: absolute; height: 1px; width: 1px; top:-1000px; background-color: transparent;" scrolling="no"
        frameborder="0"></iframe>
<style type="text/css">.widget-button.right-center:after {
    border-left-color: #5c9916 !important;
}

.sender-invite-container.right-center:after {
    border-left-color: #fff !important;
}</style>
<div class="widget-button widget-button-i68481723518 right-center" style="background-color:#5c9916!important;">
    <div class="widget-button-logo-wrapper"><span class="widget-button-logo"
                                                  style="background-image: url(&quot;https://widget.sender.mobi/build/images/company-logo.png&quot;);"></span>
    </div>
    <div class="widget-button-text"><span class="widget-button-text-char ">Д</span><span
            class="widget-button-text-char ">о</span><span class="widget-button-text-char ">п</span><span
            class="widget-button-text-char ">о</span><span class="widget-button-text-char ">м</span><span
            class="widget-button-text-char ">о</span><span class="widget-button-text-char ">г</span><span
            class="widget-button-text-char ">а</span><span class="widget-button-text-char "> </span><span
            class="widget-button-text-char ">о</span><span class="widget-button-text-char ">н</span><span
            class="widget-button-text-char ">л</span><span class="widget-button-text-char ">а</span><span
            class="widget-button-text-char ">й</span><span class="widget-button-text-char ">н</span></div>
</div>
</body>
</html>