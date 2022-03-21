INSERT INTO TBL_PLAYERS (first_name, last_name,user_name,current_balance) VALUES
  ('John', 'Wick','wickj', 0),
  ('Cheslin', 'Kolbe','kolbc',1000),
  ('Billy', 'Walters', 'wbilly3',1500);


INSERT INTO TBL_PLAYERS_LOG (transaction_id, player_id,transaction_type,api_request_message,
api_response_message,http_method) VALUES
  ('45639eb7-4f95-4281-8430-219cd570178b', 2, 'GET_PLAYER','','OK','GET');