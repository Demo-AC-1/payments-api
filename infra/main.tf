provider "aws" {
  region = "us-east-1"
}

resource "aws_s3_bucket" "payments_receipts" {
  bucket = "acme-payments-receipts-prod"
  acl    = "public-read"
}

resource "aws_security_group" "payments_api" {
  name        = "payments-api-sg"
  description = "payments api"

  ingress {
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }
}
